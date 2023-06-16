using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;


namespace Gravity
{
    public partial class Introducere_planeta : Form
    {
        public Planet planeta_noua;
        public bool salveaza_in_fisier = false;
        public Introducere_planeta()
        {
            InitializeComponent();
        }

        private void Introducere_planeta_Load(object sender, EventArgs e)
        {
            
        }

        private void buttonAdauga_Click(object sender, EventArgs e)
        {
            if (boxCuloare.Text == "Selecteaza culoarea..." || Int32.Parse(txtMasa.Text) <= 0 || Int32.Parse(txtExponentMasa.Text) <= 20 || trackDistana.Value==0)
                MessageBox.Show("Date invalide!");
            else
            {
                double x = trackDistana.Value * Planet.AU;
                double y = 0;
                double mass = Int32.Parse(txtMasa.Text) * Math.Pow(10, Int32.Parse(txtExponentMasa.Text));
                double radius = trackDiametru.Value;
                double y_vel = trackViteza.Value * 1000;
                Color color = Color.FromName(boxCuloare.Text);

                if (boxSalvare.Checked == true)
                    salveaza_in_fisier = true;

                boxSalvare.Checked = false;
                planeta_noua = new Planet(x, y, mass, radius, color, 0, y_vel);

            }
            this.Close();
        }

        private void trackDiametru_Scroll(object sender, EventArgs e)
        {
            ValoareDiametru.Text = trackDiametru.Value.ToString();
        }

        private void trackViteza_Scroll(object sender, EventArgs e)
        {
            ValoareViteza.Text = trackViteza.Value.ToString();
        }

        private void trackDistana_Scroll(object sender, EventArgs e)
        {
            ValoareDistana.Text = trackDistana.Value.ToString();
        }
    }
}
