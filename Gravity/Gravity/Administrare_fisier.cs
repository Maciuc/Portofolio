using System;
using System.IO;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Gravity
{
    public class Administrare_fisier
    {
        private string numeFisier;
        public Administrare_fisier(string numeFisier)
        {
            this.numeFisier = numeFisier;

            Stream streamFisierText = File.Open(numeFisier, FileMode.OpenOrCreate);
            streamFisierText.Close();
        }
        public void AddPlanetaInFisier(Planet planeta)
        {
            using (StreamWriter TextPentruFisier = new StreamWriter(numeFisier, true))
            {
                TextPentruFisier.WriteLine(planeta.ConversieLaSir_PentruFisier());
            }
        }
        public List<Planet> GetPlanets()
        {
            List<Planet> Planets = new List<Planet>();
            using (StreamReader streamReader = new StreamReader(numeFisier))
            {
                string linieFisier;
                while ((linieFisier = streamReader.ReadLine()) != null)
                    Planets.Add(new Planet(linieFisier));
            }
                return Planets;
        }

    }
}
