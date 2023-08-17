namespace PPS_Lab
{
    partial class MenuForAdmin
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
            this.menuL = new System.Windows.Forms.Label();
            this.viewingJournalB = new System.Windows.Forms.Button();
            this.returnForLoginB = new System.Windows.Forms.Button();
            this.exitB = new System.Windows.Forms.Button();
            this.editBDB = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // menuL
            // 
            this.menuL.Anchor = System.Windows.Forms.AnchorStyles.Top;
            this.menuL.AutoSize = true;
            this.menuL.Font = new System.Drawing.Font("Microsoft Sans Serif", 36F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.menuL.Location = new System.Drawing.Point(323, 31);
            this.menuL.Name = "menuL";
            this.menuL.Size = new System.Drawing.Size(149, 55);
            this.menuL.TabIndex = 0;
            this.menuL.Text = "Menu";
            // 
            // viewingJournalB
            // 
            this.viewingJournalB.Font = new System.Drawing.Font("Microsoft Sans Serif", 21.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.viewingJournalB.Location = new System.Drawing.Point(111, 127);
            this.viewingJournalB.Name = "viewingJournalB";
            this.viewingJournalB.Size = new System.Drawing.Size(581, 64);
            this.viewingJournalB.TabIndex = 2;
            this.viewingJournalB.Text = "Просмотр журнала";
            this.viewingJournalB.UseVisualStyleBackColor = true;
            this.viewingJournalB.Click += new System.EventHandler(this.viewingJournalB_Click);
            // 
            // returnForLoginB
            // 
            this.returnForLoginB.Font = new System.Drawing.Font("Microsoft Sans Serif", 21.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.returnForLoginB.Location = new System.Drawing.Point(111, 287);
            this.returnForLoginB.Name = "returnForLoginB";
            this.returnForLoginB.Size = new System.Drawing.Size(581, 64);
            this.returnForLoginB.TabIndex = 3;
            this.returnForLoginB.Text = "Вернуться к авторизации";
            this.returnForLoginB.UseVisualStyleBackColor = true;
            this.returnForLoginB.Click += new System.EventHandler(this.returnForLoginB_Click);
            // 
            // exitB
            // 
            this.exitB.Font = new System.Drawing.Font("Microsoft Sans Serif", 21.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.exitB.Location = new System.Drawing.Point(111, 368);
            this.exitB.Name = "exitB";
            this.exitB.Size = new System.Drawing.Size(581, 64);
            this.exitB.TabIndex = 4;
            this.exitB.Text = "Выход";
            this.exitB.UseVisualStyleBackColor = true;
            this.exitB.Click += new System.EventHandler(this.exitB_Click);
            // 
            // editBDB
            // 
            this.editBDB.Font = new System.Drawing.Font("Microsoft Sans Serif", 21.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.editBDB.Location = new System.Drawing.Point(111, 206);
            this.editBDB.Name = "editBDB";
            this.editBDB.Size = new System.Drawing.Size(581, 64);
            this.editBDB.TabIndex = 5;
            this.editBDB.Text = "Редактирование базы данных";
            this.editBDB.UseVisualStyleBackColor = true;
            this.editBDB.Click += new System.EventHandler(this.editBDB_Click);
            // 
            // MenuForAdmin
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 473);
            this.Controls.Add(this.returnForLoginB);
            this.Controls.Add(this.exitB);
            this.Controls.Add(this.editBDB);
            this.Controls.Add(this.viewingJournalB);
            this.Controls.Add(this.menuL);
            this.MaximizeBox = false;
            this.MinimizeBox = false;
            this.Name = "MenuForAdmin";
            this.Text = "Form1";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label menuL;
        private System.Windows.Forms.Button viewingJournalB;
        private System.Windows.Forms.Button returnForLoginB;
        private System.Windows.Forms.Button exitB;
        private System.Windows.Forms.Button editBDB;
    }
}