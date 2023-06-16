using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Threading;
using WMPLib;

namespace Gravity
{
    public partial class Interface : Form
    {
        bool run = true;
        WindowsMediaPlayer player = new WindowsMediaPlayer();
        Bitmap btm;
        Thread th;
        Graphics figura;
        Graphics background;
        List<Planet> Planets = new List<Planet>();
        Introducere_planeta fereasta_introducere = new Introducere_planeta();
        Administrare_fisier adminPlanets;

        RectangleF forma;
        public Interface()
        {
            InitializeComponent();
        }
        private void Interface_Load(object sender, EventArgs e)
        {

            player.URL = "The-Beginning-w-Caturday.mp3";
            player.controls.play();
            player.settings.volume = 10;

            btm = new Bitmap(1400, 900);
            background = Graphics.FromImage(btm);
            figura = CreateGraphics();
            th = new Thread(Draw);
            th.IsBackground = true;
            th.Start();
        }
        public void Draw()
        {
            string numeFisier = "Planets.txt";
            string caleCompletaFisier = Path.GetFullPath(numeFisier);
            adminPlanets = new Administrare_fisier(caleCompletaFisier);

            /*double sun_mass = 1.989 * Math.Pow(10, 30);
            double mars_mass = 6.39 * Math.Pow(10, 23);
            double earth_mass = 5.972 * Math.Pow(10, 24);
            double mars_velocity = 24.077 * 1000;
            double earth_velocity = 29.783 * 1000;

            Planet sun = new Planet(0, 0, sun_mass, 30, Color.Yellow,0,0);
            Planet mars = new Planet(1.524 * Planet.AU, 0, mars_mass, 15, Color.DarkRed,0,mars_velocity);
            Planet earth = new Planet(1 * Planet.AU, 0, earth_mass, 16, Color.Blue,0,earth_velocity);

            Planets.Add(sun);
            Planets.Add(earth);
            Planets.Add(mars);

            foreach (Planet planeta in Planets)
                adminPlanets.AddPlanetaInFisier(planeta);*/

            Planets = adminPlanets.GetPlanets();

            figura.Clear(Color.Black);
            PointF punct = new Point(0, 0);

            while (run)
            {
                background.Clear(Color.Black);
                foreach (Planet planet in Planets)
                {
                    SolidBrush culoare_planeta = new SolidBrush(planet.color);
                    forma = planet.DrawPlanet();

                    if (planet!=Planets[0])
                        planet.update_position(Planets);

                    background.FillEllipse(culoare_planeta, forma);
                }
                figura.DrawImage(btm, punct);
            }
        }
        private void button_adauga_Click(object sender, EventArgs e)
        {
            fereasta_introducere.ShowDialog();
            if (fereasta_introducere.planeta_noua!=null)
            {
                Planets.Add(fereasta_introducere.planeta_noua);
                if (fereasta_introducere.salveaza_in_fisier==true)
                    adminPlanets.AddPlanetaInFisier(fereasta_introducere.planeta_noua);
                fereasta_introducere.planeta_noua = null;

                lblReusit.Visible = true;
                lblPress.Visible = true;
            }
        }
        private void lblReusit_Click(object sender, EventArgs e)
        {
            lblReusit.Visible = false;
            lblPress.Visible = false;
        }
    }
}
