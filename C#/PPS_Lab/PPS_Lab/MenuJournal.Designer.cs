namespace PPS_Lab
{
    partial class MenuJournal
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
            this.journalL = new System.Windows.Forms.Label();
            this.returnToMenuB = new System.Windows.Forms.Button();
            this.db = new System.Windows.Forms.DataGridView();
            this.Column3 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.Column4 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.Column1 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.Column5 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.Column6 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            ((System.ComponentModel.ISupportInitialize)(this.db)).BeginInit();
            this.SuspendLayout();
            // 
            // journalL
            // 
            this.journalL.AutoSize = true;
            this.journalL.Font = new System.Drawing.Font("Microsoft Sans Serif", 36F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.journalL.Location = new System.Drawing.Point(286, 9);
            this.journalL.Name = "journalL";
            this.journalL.Size = new System.Drawing.Size(189, 55);
            this.journalL.TabIndex = 0;
            this.journalL.Text = "Journal";
            // 
            // returnToMenuB
            // 
            this.returnToMenuB.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.returnToMenuB.Location = new System.Drawing.Point(700, 12);
            this.returnToMenuB.Name = "returnToMenuB";
            this.returnToMenuB.Size = new System.Drawing.Size(88, 28);
            this.returnToMenuB.TabIndex = 6;
            this.returnToMenuB.Text = "Вернуться к меню";
            this.returnToMenuB.UseVisualStyleBackColor = true;
            this.returnToMenuB.Click += new System.EventHandler(this.returnToMenuB_Click);
            // 
            // db
            // 
            this.db.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.db.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.Column3,
            this.Column4,
            this.Column1,
            this.Column5,
            this.Column6});
            this.db.Location = new System.Drawing.Point(64, 67);
            this.db.Name = "db";
            this.db.Size = new System.Drawing.Size(664, 343);
            this.db.TabIndex = 52;
            // 
            // Column3
            // 
            this.Column3.HeaderText = "answer";
            this.Column3.Name = "Column3";
            this.Column3.Width = 200;
            // 
            // Column4
            // 
            this.Column4.HeaderText = "task";
            this.Column4.Name = "Column4";
            this.Column4.Width = 200;
            // 
            // Column1
            // 
            this.Column1.HeaderText = "deadline";
            this.Column1.Name = "Column1";
            // 
            // Column5
            // 
            this.Column5.HeaderText = "mark";
            this.Column5.Name = "Column5";
            this.Column5.Width = 50;
            // 
            // Column6
            // 
            this.Column6.HeaderText = "flag";
            this.Column6.Name = "Column6";
            this.Column6.Width = 70;
            // 
            // MenuJournal
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.Controls.Add(this.db);
            this.Controls.Add(this.returnToMenuB);
            this.Controls.Add(this.journalL);
            this.MaximizeBox = false;
            this.MinimizeBox = false;
            this.Name = "MenuJournal";
            this.Text = "MenuJournal";
            ((System.ComponentModel.ISupportInitialize)(this.db)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label journalL;
        private System.Windows.Forms.Button returnToMenuB;
        private System.Windows.Forms.DataGridView db;
        private System.Windows.Forms.DataGridViewTextBoxColumn Column3;
        private System.Windows.Forms.DataGridViewTextBoxColumn Column4;
        private System.Windows.Forms.DataGridViewTextBoxColumn Column1;
        private System.Windows.Forms.DataGridViewTextBoxColumn Column5;
        private System.Windows.Forms.DataGridViewTextBoxColumn Column6;
    }
}