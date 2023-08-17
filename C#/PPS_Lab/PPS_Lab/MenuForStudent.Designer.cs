namespace PPS_Lab
{
    partial class MenuForStudent
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
            this.label1 = new System.Windows.Forms.Label();
            this.viewingJournalB = new System.Windows.Forms.Button();
            this.submitTaskB = new System.Windows.Forms.Button();
            this.exitB = new System.Windows.Forms.Button();
            this.returnForLoginB = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Microsoft Sans Serif", 36F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.label1.Location = new System.Drawing.Point(319, 32);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(149, 55);
            this.label1.TabIndex = 0;
            this.label1.Text = "Menu";
            // 
            // viewingJournalB
            // 
            this.viewingJournalB.Font = new System.Drawing.Font("Microsoft Sans Serif", 21.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.viewingJournalB.Location = new System.Drawing.Point(107, 125);
            this.viewingJournalB.Name = "viewingJournalB";
            this.viewingJournalB.Size = new System.Drawing.Size(581, 64);
            this.viewingJournalB.TabIndex = 1;
            this.viewingJournalB.Text = "Просмотр журнала";
            this.viewingJournalB.UseVisualStyleBackColor = true;
            this.viewingJournalB.Click += new System.EventHandler(this.viewingJournalB_Click);
            // 
            // submitTaskB
            // 
            this.submitTaskB.Font = new System.Drawing.Font("Microsoft Sans Serif", 21.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.submitTaskB.Location = new System.Drawing.Point(107, 204);
            this.submitTaskB.Name = "submitTaskB";
            this.submitTaskB.Size = new System.Drawing.Size(581, 64);
            this.submitTaskB.TabIndex = 1;
            this.submitTaskB.Text = "Сдать задание";
            this.submitTaskB.UseVisualStyleBackColor = true;
            this.submitTaskB.Click += new System.EventHandler(this.submitTaskB_Click);
            // 
            // exitB
            // 
            this.exitB.Font = new System.Drawing.Font("Microsoft Sans Serif", 21.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.exitB.Location = new System.Drawing.Point(107, 366);
            this.exitB.Name = "exitB";
            this.exitB.Size = new System.Drawing.Size(581, 64);
            this.exitB.TabIndex = 1;
            this.exitB.Text = "Выход";
            this.exitB.UseVisualStyleBackColor = true;
            this.exitB.Click += new System.EventHandler(this.exitB_Click);
            // 
            // returnForLoginB
            // 
            this.returnForLoginB.Font = new System.Drawing.Font("Microsoft Sans Serif", 21.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.returnForLoginB.Location = new System.Drawing.Point(107, 285);
            this.returnForLoginB.Name = "returnForLoginB";
            this.returnForLoginB.Size = new System.Drawing.Size(581, 64);
            this.returnForLoginB.TabIndex = 1;
            this.returnForLoginB.Text = "Вернуться к авторизации";
            this.returnForLoginB.UseVisualStyleBackColor = true;
            this.returnForLoginB.Click += new System.EventHandler(this.returnForLoginB_Click);
            // 
            // MenuForStudent
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 478);
            this.Controls.Add(this.returnForLoginB);
            this.Controls.Add(this.exitB);
            this.Controls.Add(this.submitTaskB);
            this.Controls.Add(this.viewingJournalB);
            this.Controls.Add(this.label1);
            this.MaximizeBox = false;
            this.MinimizeBox = false;
            this.Name = "MenuForStudent";
            this.Text = "Menu";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Button viewingJournalB;
        private System.Windows.Forms.Button submitTaskB;
        private System.Windows.Forms.Button exitB;
        private System.Windows.Forms.Button returnForLoginB;
    }
}