using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Drawing;

namespace Gravity
{
    public class Planet
    {
        public const double WIDTH = 1400;
        public const double HEIGHT = 900-39; //39 repr title bar

        public const double AU = 149.587e9;
        public const double G = 6.6743e-11;
        public const double SCALE = 150 / AU; //cati pixeli repra o Unitate Astronomica
        public const double TIMESTEP = 3600 * 48 ;

        public double mass, x_vel, y_vel, x, y, radius;
        public Color color;
        public Tuple<double, double>[] orbit = new Tuple<double, double>[10000];

        public Planet ( double x,double y, double mass,double radius,Color color,double x_vel,double y_vel)
        {
            this.x = x;
            this.y = y;
            this.color = color;
            this.mass = mass;
            this.radius = radius;
            this.x_vel = x_vel;
            this.y_vel = y_vel;
        }
        public Planet(string linieFisier)
        {
            var dateFisier = linieFisier.Split(';');

            x = Convert.ToDouble(dateFisier[0]);
            y = Convert.ToDouble(dateFisier[1]);
            mass = Convert.ToDouble(dateFisier[2]);
            radius = Convert.ToDouble(dateFisier[3]);
            color = Color.FromName(dateFisier[4]);
            x_vel = Convert.ToDouble(dateFisier[5]);
            y_vel = Convert.ToDouble(dateFisier[6]);
        }
        public RectangleF DrawPlanet ()
        {
            SolidBrush colorfill = new SolidBrush(color);
            double x_shape = x * SCALE + WIDTH / 2-radius;
            double y_shape = y * SCALE + HEIGHT / 2-radius;
            double width = radius * 2 ;
            double height = radius * 2 ;
            RectangleF shape = new RectangleF((float)x_shape, (float)y_shape, (float)width, (float)height);
            return shape;

        }
        public Tuple<double,double> Attraction(Planet planeta_atrasa)//calculeaa forta de atractie dintre 2 planete
        {
            double distance_x = planeta_atrasa.x - x ;
            double distance_y = planeta_atrasa.y - y ;
            double distance = Math.Sqrt(distance_x * distance_x + distance_y * distance_y);

            double force = G * mass * planeta_atrasa.mass / (distance * distance); //Newton's law of universal gravitation
            double theta = Math.Atan2(distance_y, distance_x);
            double force_x = Math.Cos(theta) * force;
            double force_y = Math.Sin(theta) * force;

            return Tuple.Create(force_x,force_y);
        }
        public void update_position(List<Planet> planets)
        {
            double total_force_x = 0, total_force_y = 0;
            foreach (Planet planet in planets)
            {
                if (this == planet )
                    continue;
                double force_x, force_y;
                (force_x,force_y) =Attraction(planet);
                total_force_x += force_x;
                total_force_y += force_y;
            }
            x_vel += total_force_x / mass * TIMESTEP;
            y_vel += total_force_y / mass * TIMESTEP;
            x += x_vel * TIMESTEP;
            y += y_vel * TIMESTEP;
            Tuple<double, double> coord=new Tuple<double,double>(x,y);
            orbit.Append(coord);
        }

        public string ConversieLaSir_PentruFisier()
        {
            string obiectPentruFisier = string.Format("{1}{0}{2}{0}{3}{0}{4}{0}{5}{0}{6}{0}{7}{0}",
                ";", x, y, mass, radius, color.Name, x_vel, y_vel);
            return obiectPentruFisier;
        }

    }
}
