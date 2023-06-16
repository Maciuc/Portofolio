# Clasa de autorizare „Dummy”, este potrivită pentru subclasare pentru
# a crea proprii “authorizers”. Un „ authorizer” este o clasă care gestionează
# autentificări și permisiuni ale serverului FTP. Este folosit în interiorul
# clasei “pyftpdlib.handlers.FTPHandler” pentru verificarea parolei utilizatorului,
# obținerea directorului principal al utilizatorilor, verificarea permisiunilor
# utilizatorului atunci când are loc un eveniment de citire/scriere a sistemului
# de fișiere și schimbarea utilizatorului înainte de a accesa sistemul de fișiere.
from pyftpdlib.authorizers import DummyAuthorizer

# Această clasă implementează serverul FTP gestionând comenzile primite de la client
# pe canalul de control prin apelarea metodei corespunzătoare comenzii.
from pyftpdlib.handlers import FTPHandler

#Creează un socket care ascultă address-ul, trimițând cererile către handler.
from pyftpdlib.servers import FTPServer

# Portul pe care server-ul FTP il va folosi.
# Numarul trebuie sa fie mai mare decat 1023 deoarece
# porturile de la 0 la 1023 sunt rezervate, numite si "well-known ports".
PORT_FTP = 1234

# Numele utilizatorului care se poate loga pe server-ul FTP.
UTILIZATOR_FTP = "Gabri"

# Parola utilizatorului.
PAROLA_FTP = "parola"

# Directorul care va contine informatiile.
DIRECTOR_FTP = "C:/Users/gabri/OneDrive/Documents/RC_proiect/ftp_content"


def main():
    # Creeaza o instantiere a unui "authorizer" inactiv pentru a gestiona
    # utilizatorii virtuali.
    authorizer = DummyAuthorizer()

    # Definim un nou utilizator care va avea anumite permisiuni date de variabila "perm".
    authorizer.add_user(UTILIZATOR_FTP, PAROLA_FTP, DIRECTOR_FTP, perm='elrafmw')

    # Creeaza o instantiere a unui "handler".
    handler = FTPHandler
    handler.authorizer = authorizer

    # Se instatiaza clasa server-ului FTP si va folosi adresa '127.0.0.1:1234'
    address = ('127.0.0.1', PORT_FTP)
    server = FTPServer(address, handler)

    # Se creeaza o limitare de conexiuni.
    server.max_cons = 256
    server.max_cons_per_ip = 5

    # Face server-ul sa functioneze pana se va inchide aplicatia python.
    server.serve_forever()


if __name__ == '__main__':
    main()
