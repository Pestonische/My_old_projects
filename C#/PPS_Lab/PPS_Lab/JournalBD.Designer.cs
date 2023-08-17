namespace PPS_Lab
{
    partial class JournalBD
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
            this.prCB = new System.Windows.Forms.ComboBox();
            this.userL = new System.Windows.Forms.Label();
            this.journalL = new System.Windows.Forms.Label();
            this.deleteIdTB = new System.Windows.Forms.TextBox();
            this.label6 = new System.Windows.Forms.Label();
            this.deleteB = new System.Windows.Forms.Button();
            this.db = new System.Windows.Forms.DataGridView();
            this.Column1 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.Column2 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.Column3 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.Column4 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.Column5 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            ((System.ComponentModel.ISupportInitialize)(this.db)).BeginInit();
            this.SuspendLayout();
            // 
            // returnToMenuB
            // 
            this.returnToMenuB.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.returnToMenuB.Location = new System.Drawing.Point(690, 12);
            this.returnToMenuB.Name = "returnToMenuB";
            this.returnToMenuB.Size = new System.Drawing.Size(88, 28);
            this.returnToMenuB.TabIndex = 10;
            this.returnToMenuB.Text = "Вернуться к меню";
            this.returnToMenuB.UseVisualStyleBackColor = true;
            this.returnToMenuB.Click += new System.EventHandler(this.returnToMenuB_Click);
            // 
            // prCB
            // 
            this.prCB.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.prCB.Font = new System.Drawing.Font("Microsoft Sans Serif", 21.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.prCB.FormattingEnabled = true;
            this.prCB.Location = new System.Drawing.Point(418, 61);
            this.prCB.Name = "prCB";
            this.prCB.Size = new System.Drawing.Size(151, 41);
            this.prCB.TabIndex = 9;
            this.prCB.SelectedIndexChanged += new System.EventHandler(this.prCB_SelectedIndexChanged);
            // 
            // userL
            // 
            this.userL.AutoSize = true;
            this.userL.Font = new System.Drawing.Font("Microsoft Sans Serif", 21.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.userL.Location = new System.Drawing.Point(205, 64);
            this.userL.Name = "userL";
            this.userL.Size = new System.Drawing.Size(207, 33);
            this.userL.TabIndex = 8;
            this.userL.Text = "Пользователь";
            // 
            // journalL
            // 
            this.journalL.AutoSize = true;
            this.journalL.Font = new System.Drawing.Font("Microsoft Sans Serif", 36F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.journalL.Location = new System.Drawing.Point(276, 9);
            this.journalL.Name = "journalL";
            this.journalL.Size = new System.Drawing.Size(189, 55);
            this.journalL.TabIndex = 7;
            this.journalL.Text = "Journal";
            // 
            // deleteIdTB
            // 
            this.deleteIdTB.Font = new System.Drawing.Font("Microsoft Sans Serif", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.deleteIdTB.Location = new System.Drawing.Point(63, 386);
            this.deleteIdTB.Name = "deleteIdTB";
            this.deleteIdTB.Size = new System.Drawing.Size(100, 31);
            this.deleteIdTB.TabIndex = 21;
            this.deleteIdTB.TextChanged += new System.EventHandler(this.deleteIdTB_TextChanged);
            // 
            // label6
            // 
            this.label6.AutoSize = true;
            this.label6.Font = new System.Drawing.Font("Microsoft Sans Serif", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.label6.Location = new System.Drawing.Point(58, 358);
            this.label6.Name = "label6";
            this.label6.Size = new System.Drawing.Size(383, 25);
            this.label6.TabIndex = 22;
            this.label6.Text = "Введите ID того кого хотите удалить ";
            // 
            // deleteB
            // 
            this.deleteB.Font = new System.Drawing.Font("Microsoft Sans Serif", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.deleteB.Location = new System.Drawing.Point(211, 386);
            this.deleteB.Name = "deleteB";
            this.deleteB.Size = new System.Drawing.Size(94, 31);
            this.deleteB.TabIndex = 23;
            this.deleteB.Text = "Delete";
            this.deleteB.UseVisualStyleBackColor = true;
            this.deleteB.Click += new System.EventHandler(this.deleteB_Click);
            // 
            // db
            // 
            this.db.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.db.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.Column1,
            this.Column2,
            this.Column3,
            this.Column4,
            this.Column5});
            this.db.Location = new System.Drawing.Point(47, 108);
            this.db.Name = "db";
            this.db.Size = new System.Drawing.Size(715, 237);
            this.db.TabIndex = 24;
            // 
            // Column1
            // 
            this.Column1.HeaderText = "id";
            this.Column1.Name = "Column1";
            this.Column1.Width = 50;
            // 
            // Column2
            // 
            this.Column2.HeaderText = "name";
            this.Column2.Name = "Column2";
            this.Column2.Width = 200;
            // 
            // Column3
            // 
            this.Column3.HeaderText = "login";
            this.Column3.Name = "Column3";
            this.Column3.Width = 120;
            // 
            // Column4
            // 
            this.Column4.HeaderText = "role";
            this.Column4.Name = "Column4";
            this.Column4.Width = 150;
            // 
            // Column5
            // 
            this.Column5.HeaderText = "password";
            this.Column5.Name = "Column5";
            this.Column5.Width = 150;
            // 
            // JournalBD
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.Controls.Add(this.db);
            this.Controls.Add(this.deleteB);
            this.Controls.Add(this.label6);
            this.Controls.Add(this.deleteIdTB);
            this.Controls.Add(this.returnToMenuB);
            this.Controls.Add(this.prCB);
            this.Controls.Add(this.userL);
            this.Controls.Add(this.journalL);
            this.MaximizeBox = false;
            this.MinimizeBox = false;
            this.Name = "JournalBD";
            this.Text = "JournalBD";
            ((System.ComponentModel.ISupportInitialize)(this.db)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Button returnToMenuB;
        private System.Windows.Forms.ComboBox prCB;
        private System.Windows.Forms.Label userL;
        private System.Windows.Forms.Label journalL;
        private System.Windows.Forms.TextBox deleteIdTB;
        private System.Windows.Forms.Label label6;
        private System.Windows.Forms.Button deleteB;
        private System.Windows.Forms.DataGridView db;
        private System.Windows.Forms.DataGridViewTextBoxColumn Column1;
        private System.Windows.Forms.DataGridViewTextBoxColumn Column2;
        private System.Windows.Forms.DataGridViewTextBoxColumn Column3;
        private System.Windows.Forms.DataGridViewTextBoxColumn Column4;
        private System.Windows.Forms.DataGridViewTextBoxColumn Column5;
    }
}