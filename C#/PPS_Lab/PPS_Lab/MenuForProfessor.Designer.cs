namespace PPS_Lab
{
    partial class MenuForProfessor
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
            this.returnForLoginB = new System.Windows.Forms.Button();
            this.exitB = new System.Windows.Forms.Button();
            this.addTaskB = new System.Windows.Forms.Button();
            this.editJournalB = new System.Windows.Forms.Button();
            this.label1 = new System.Windows.Forms.Label();
            this.giveTaskB = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // returnForLoginB
            // 
            this.returnForLoginB.Font = new System.Drawing.Font("Microsoft Sans Serif", 21.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.returnForLoginB.Location = new System.Drawing.Point(110, 314);
            this.returnForLoginB.Name = "returnForLoginB";
            this.returnForLoginB.Size = new System.Drawing.Size(581, 48);
            this.returnForLoginB.TabIndex = 3;
            this.returnForLoginB.Text = "Вернуться к авторизации";
            this.returnForLoginB.UseVisualStyleBackColor = true;
            this.returnForLoginB.Click += new System.EventHandler(this.returnForLoginB_Click);
            // 
            // exitB
            // 
            this.exitB.Font = new System.Drawing.Font("Microsoft Sans Serif", 21.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.exitB.Location = new System.Drawing.Point(110, 376);
            this.exitB.Name = "exitB";
            this.exitB.Size = new System.Drawing.Size(581, 48);
            this.exitB.TabIndex = 4;
            this.exitB.Text = "Выход";
            this.exitB.UseVisualStyleBackColor = true;
            this.exitB.Click += new System.EventHandler(this.exitB_Click);
            // 
            // addTaskB
            // 
            this.addTaskB.Font = new System.Drawing.Font("Microsoft Sans Serif", 21.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.addTaskB.Location = new System.Drawing.Point(110, 197);
            this.addTaskB.Name = "addTaskB";
            this.addTaskB.Size = new System.Drawing.Size(581, 48);
            this.addTaskB.TabIndex = 5;
            this.addTaskB.Text = "Добавить задание";
            this.addTaskB.UseVisualStyleBackColor = true;
            this.addTaskB.Click += new System.EventHandler(this.addTaskB_Click);
            // 
            // editJournalB
            // 
            this.editJournalB.Font = new System.Drawing.Font("Microsoft Sans Serif", 21.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.editJournalB.Location = new System.Drawing.Point(110, 135);
            this.editJournalB.Name = "editJournalB";
            this.editJournalB.Size = new System.Drawing.Size(581, 48);
            this.editJournalB.TabIndex = 6;
            this.editJournalB.Text = "Редактировать журнал";
            this.editJournalB.UseVisualStyleBackColor = true;
            this.editJournalB.Click += new System.EventHandler(this.editJournalB_Click);
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Microsoft Sans Serif", 36F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.label1.Location = new System.Drawing.Point(322, 26);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(149, 55);
            this.label1.TabIndex = 2;
            this.label1.Text = "Menu";
            // 
            // giveTaskB
            // 
            this.giveTaskB.Font = new System.Drawing.Font("Microsoft Sans Serif", 21.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.giveTaskB.Location = new System.Drawing.Point(110, 251);
            this.giveTaskB.Name = "giveTaskB";
            this.giveTaskB.Size = new System.Drawing.Size(581, 48);
            this.giveTaskB.TabIndex = 7;
            this.giveTaskB.Text = "Выдать задание";
            this.giveTaskB.UseVisualStyleBackColor = true;
            this.giveTaskB.Click += new System.EventHandler(this.giveTaskB_Click);
            // 
            // MenuForProfessor
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.Controls.Add(this.giveTaskB);
            this.Controls.Add(this.returnForLoginB);
            this.Controls.Add(this.exitB);
            this.Controls.Add(this.addTaskB);
            this.Controls.Add(this.editJournalB);
            this.Controls.Add(this.label1);
            this.MaximizeBox = false;
            this.MinimizeBox = false;
            this.Name = "MenuForProfessor";
            this.Text = "MenuForProfessor";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Button returnForLoginB;
        private System.Windows.Forms.Button exitB;
        private System.Windows.Forms.Button addTaskB;
        private System.Windows.Forms.Button editJournalB;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Button giveTaskB;
    }
}