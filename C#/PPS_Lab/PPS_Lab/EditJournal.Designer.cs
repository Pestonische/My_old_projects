namespace PPS_Lab
{
    partial class EditJournal
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
            this.returnToMenuB = new System.Windows.Forms.Button();
            this.journalL = new System.Windows.Forms.Label();
            this.idTB = new System.Windows.Forms.TextBox();
            this.markB = new System.Windows.Forms.TextBox();
            this.enterB = new System.Windows.Forms.Button();
            this.label7 = new System.Windows.Forms.Label();
            this.label8 = new System.Windows.Forms.Label();
            this.label9 = new System.Windows.Forms.Label();
            this.db = new System.Windows.Forms.DataGridView();
            this.Column1 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.Column7 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.Column2 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.Column3 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.Column4 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.Column5 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.Column6 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            ((System.ComponentModel.ISupportInitialize)(this.db)).BeginInit();
            this.SuspendLayout();
            // 
            // returnToMenuB
            // 
            this.returnToMenuB.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.returnToMenuB.Location = new System.Drawing.Point(693, 12);
            this.returnToMenuB.Name = "returnToMenuB";
            this.returnToMenuB.Size = new System.Drawing.Size(88, 28);
            this.returnToMenuB.TabIndex = 14;
            this.returnToMenuB.Text = "Вернуться к меню";
            this.returnToMenuB.UseVisualStyleBackColor = true;
            this.returnToMenuB.Click += new System.EventHandler(this.returnToMenuB_Click);
            // 
            // journalL
            // 
            this.journalL.AutoSize = true;
            this.journalL.Font = new System.Drawing.Font("Microsoft Sans Serif", 36F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.journalL.Location = new System.Drawing.Point(279, 9);
            this.journalL.Name = "journalL";
            this.journalL.Size = new System.Drawing.Size(189, 55);
            this.journalL.TabIndex = 11;
            this.journalL.Text = "Journal";
            // 
            // idTB
            // 
            this.idTB.Font = new System.Drawing.Font("Microsoft Sans Serif", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.idTB.Location = new System.Drawing.Point(94, 395);
            this.idTB.Name = "idTB";
            this.idTB.Size = new System.Drawing.Size(100, 31);
            this.idTB.TabIndex = 33;
            this.idTB.TextChanged += new System.EventHandler(this.idTB_TextChanged);
            // 
            // markB
            // 
            this.markB.Font = new System.Drawing.Font("Microsoft Sans Serif", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.markB.Location = new System.Drawing.Point(266, 395);
            this.markB.Name = "markB";
            this.markB.Size = new System.Drawing.Size(100, 31);
            this.markB.TabIndex = 38;
            this.markB.TextChanged += new System.EventHandler(this.markB_TextChanged);
            // 
            // enterB
            // 
            this.enterB.Location = new System.Drawing.Point(423, 395);
            this.enterB.Name = "enterB";
            this.enterB.Size = new System.Drawing.Size(91, 31);
            this.enterB.TabIndex = 39;
            this.enterB.Text = "Enter";
            this.enterB.UseVisualStyleBackColor = true;
            this.enterB.Click += new System.EventHandler(this.enterB_Click);
            // 
            // label7
            // 
            this.label7.AutoSize = true;
            this.label7.Font = new System.Drawing.Font("Microsoft Sans Serif", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.label7.Location = new System.Drawing.Point(39, 354);
            this.label7.Name = "label7";
            this.label7.Size = new System.Drawing.Size(602, 25);
            this.label7.TabIndex = 40;
            this.label7.Text = "Введите ID строки и отметку которую вы хотите поставить";
            // 
            // label8
            // 
            this.label8.AutoSize = true;
            this.label8.Font = new System.Drawing.Font("Microsoft Sans Serif", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.label8.Location = new System.Drawing.Point(200, 398);
            this.label8.Name = "label8";
            this.label8.Size = new System.Drawing.Size(60, 25);
            this.label8.TabIndex = 41;
            this.label8.Text = "Mark";
            // 
            // label9
            // 
            this.label9.AutoSize = true;
            this.label9.Font = new System.Drawing.Font("Microsoft Sans Serif", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.label9.Location = new System.Drawing.Point(44, 398);
            this.label9.Name = "label9";
            this.label9.Size = new System.Drawing.Size(32, 25);
            this.label9.TabIndex = 42;
            this.label9.Text = "ID";
            // 
            // db
            // 
            this.db.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.db.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.Column1,
            this.Column7,
            this.Column2,
            this.Column3,
            this.Column4,
            this.Column5,
            this.Column6});
            this.db.Location = new System.Drawing.Point(24, 67);
            this.db.Name = "db";
            this.db.Size = new System.Drawing.Size(747, 276);
            this.db.TabIndex = 43;
            // 
            // Column1
            // 
            this.Column1.HeaderText = "id";
            this.Column1.Name = "Column1";
            this.Column1.Width = 25;
            // 
            // Column7
            // 
            this.Column7.HeaderText = "specialization";
            this.Column7.Name = "Column7";
            this.Column7.Width = 75;
            // 
            // Column2
            // 
            this.Column2.HeaderText = "name";
            this.Column2.Name = "Column2";
            this.Column2.Width = 150;
            // 
            // Column3
            // 
            this.Column3.HeaderText = "answer";
            this.Column3.Name = "Column3";
            this.Column3.Width = 175;
            // 
            // Column4
            // 
            this.Column4.HeaderText = "task";
            this.Column4.Name = "Column4";
            this.Column4.Width = 175;
            // 
            // Column5
            // 
            this.Column5.HeaderText = "mark";
            this.Column5.Name = "Column5";
            this.Column5.Width = 40;
            // 
            // Column6
            // 
            this.Column6.HeaderText = "flag";
            this.Column6.Name = "Column6";
            this.Column6.Width = 60;
            // 
            // EditJournal
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.Controls.Add(this.db);
            this.Controls.Add(this.label9);
            this.Controls.Add(this.label8);
            this.Controls.Add(this.label7);
            this.Controls.Add(this.enterB);
            this.Controls.Add(this.markB);
            this.Controls.Add(this.idTB);
            this.Controls.Add(this.returnToMenuB);
            this.Controls.Add(this.journalL);
            this.MaximizeBox = false;
            this.MinimizeBox = false;
            this.Name = "EditJournal";
            this.Text = "EditJournal";
            ((System.ComponentModel.ISupportInitialize)(this.db)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Button returnToMenuB;
        private System.Windows.Forms.Label journalL;
        private System.Windows.Forms.TextBox idTB;
        private System.Windows.Forms.TextBox markB;
        private System.Windows.Forms.Button enterB;
        private System.Windows.Forms.Label label7;
        private System.Windows.Forms.Label label8;
        private System.Windows.Forms.Label label9;
        private System.Windows.Forms.DataGridView db;
        private System.Windows.Forms.DataGridViewTextBoxColumn Column1;
        private System.Windows.Forms.DataGridViewTextBoxColumn Column7;
        private System.Windows.Forms.DataGridViewTextBoxColumn Column2;
        private System.Windows.Forms.DataGridViewTextBoxColumn Column3;
        private System.Windows.Forms.DataGridViewTextBoxColumn Column4;
        private System.Windows.Forms.DataGridViewTextBoxColumn Column5;
        private System.Windows.Forms.DataGridViewTextBoxColumn Column6;
    }
}