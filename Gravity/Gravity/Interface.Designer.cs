
namespace Gravity
{
    partial class Interface
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.button_adauga = new System.Windows.Forms.Button();
            this.lblReusit = new System.Windows.Forms.Label();
            this.lblPress = new System.Windows.Forms.Label();
            this.SuspendLayout();
            // 
            // button_adauga
            // 
            this.button_adauga.Font = new System.Drawing.Font("Microsoft Sans Serif", 20.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.button_adauga.Location = new System.Drawing.Point(1252, 29);
            this.button_adauga.Name = "button_adauga";
            this.button_adauga.Size = new System.Drawing.Size(100, 55);
            this.button_adauga.TabIndex = 0;
            this.button_adauga.Text = "Add";
            this.button_adauga.UseVisualStyleBackColor = true;
            this.button_adauga.Click += new System.EventHandler(this.button_adauga_Click);
            // 
            // lblReusit
            // 
            this.lblReusit.AutoSize = true;
            this.lblReusit.BackColor = System.Drawing.SystemColors.InactiveCaptionText;
            this.lblReusit.Font = new System.Drawing.Font("Microsoft Sans Serif", 39.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblReusit.ForeColor = System.Drawing.Color.LimeGreen;
            this.lblReusit.Location = new System.Drawing.Point(1154, 710);
            this.lblReusit.Name = "lblReusit";
            this.lblReusit.Size = new System.Drawing.Size(198, 61);
            this.lblReusit.TabIndex = 1;
            this.lblReusit.Text = "Reusit!";
            this.lblReusit.Visible = false;
            this.lblReusit.Click += new System.EventHandler(this.lblReusit_Click);
            // 
            // lblPress
            // 
            this.lblPress.AutoSize = true;
            this.lblPress.Font = new System.Drawing.Font("Microsoft Sans Serif", 11.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblPress.ForeColor = System.Drawing.Color.LimeGreen;
            this.lblPress.Location = new System.Drawing.Point(1162, 771);
            this.lblPress.Name = "lblPress";
            this.lblPress.Size = new System.Drawing.Size(123, 18);
            this.lblPress.TabIndex = 1;
            this.lblPress.Text = "*press to close";
            this.lblPress.Visible = false;
            this.lblPress.Click += new System.EventHandler(this.lblReusit_Click);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.SystemColors.ActiveCaptionText;
            this.ClientSize = new System.Drawing.Size(1384, 861);
            this.Controls.Add(this.lblPress);
            this.Controls.Add(this.lblReusit);
            this.Controls.Add(this.button_adauga);
            this.Name = "Form1";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "Gravity";
            this.Load += new System.EventHandler(this.Interface_Load);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Button button_adauga;
        private System.Windows.Forms.Label lblReusit;
        private System.Windows.Forms.Label lblPress;
    }
}

