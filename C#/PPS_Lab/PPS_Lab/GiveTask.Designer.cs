namespace PPS_Lab
{
    partial class GiveTask
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
            this.db = new System.Windows.Forms.DataGridView();
            this.label9 = new System.Windows.Forms.Label();
            this.label8 = new System.Windows.Forms.Label();
            this.label7 = new System.Windows.Forms.Label();
            this.enterB = new System.Windows.Forms.Button();
            this.taskIdB = new System.Windows.Forms.TextBox();
            this.idTB = new System.Windows.Forms.TextBox();
            this.returnToMenuB = new System.Windows.Forms.Button();
            this.journalL = new System.Windows.Forms.Label();
            this.db2 = new System.Windows.Forms.DataGridView();
            this.dataGridViewTextBoxColumn1 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.dataGridViewTextBoxColumn2 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.Column1 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.Column2 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.Column3 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            ((System.ComponentModel.ISupportInitialize)(this.db)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.db2)).BeginInit();
            this.SuspendLayout();
            // 
            // db
            // 
            this.db.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.db.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.Column1,
            this.Column2,
            this.Column3});
            this.db.Location = new System.Drawing.Point(38, 75);
            this.db.Name = "db";
            this.db.Size = new System.Drawing.Size(393, 276);
            this.db.TabIndex = 52;
            // 
            // label9
            // 
            this.label9.AutoSize = true;
            this.label9.Font = new System.Drawing.Font("Microsoft Sans Serif", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.label9.Location = new System.Drawing.Point(38, 406);
            this.label9.Name = "label9";
            this.label9.Size = new System.Drawing.Size(32, 25);
            this.label9.TabIndex = 51;
            this.label9.Text = "ID";
            // 
            // label8
            // 
            this.label8.AutoSize = true;
            this.label8.Font = new System.Drawing.Font("Microsoft Sans Serif", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.label8.Location = new System.Drawing.Point(194, 406);
            this.label8.Name = "label8";
            this.label8.Size = new System.Drawing.Size(82, 25);
            this.label8.TabIndex = 50;
            this.label8.Text = "Task Id";
            // 
            // label7
            // 
            this.label7.AutoSize = true;
            this.label7.Font = new System.Drawing.Font("Microsoft Sans Serif", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.label7.Location = new System.Drawing.Point(33, 362);
            this.label7.Name = "label7";
            this.label7.Size = new System.Drawing.Size(698, 25);
            this.label7.TabIndex = 49;
            this.label7.Text = "Введите ID пользователя и ID задания которое вы хотите назначить";
            // 
            // enterB
            // 
            this.enterB.Location = new System.Drawing.Point(417, 403);
            this.enterB.Name = "enterB";
            this.enterB.Size = new System.Drawing.Size(91, 31);
            this.enterB.TabIndex = 48;
            this.enterB.Text = "Enter";
            this.enterB.UseVisualStyleBackColor = true;
            this.enterB.Click += new System.EventHandler(this.enterB_Click);
            // 
            // taskIdB
            // 
            this.taskIdB.Font = new System.Drawing.Font("Microsoft Sans Serif", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.taskIdB.Location = new System.Drawing.Point(282, 403);
            this.taskIdB.Name = "taskIdB";
            this.taskIdB.Size = new System.Drawing.Size(100, 31);
            this.taskIdB.TabIndex = 47;
            this.taskIdB.TextChanged += new System.EventHandler(this.taskIdB_TextChanged);
            // 
            // idTB
            // 
            this.idTB.Font = new System.Drawing.Font("Microsoft Sans Serif", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.idTB.Location = new System.Drawing.Point(88, 403);
            this.idTB.Name = "idTB";
            this.idTB.Size = new System.Drawing.Size(100, 31);
            this.idTB.TabIndex = 46;
            this.idTB.TextChanged += new System.EventHandler(this.idTB_TextChanged);
            // 
            // returnToMenuB
            // 
            this.returnToMenuB.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.returnToMenuB.Location = new System.Drawing.Point(687, 20);
            this.returnToMenuB.Name = "returnToMenuB";
            this.returnToMenuB.Size = new System.Drawing.Size(88, 28);
            this.returnToMenuB.TabIndex = 45;
            this.returnToMenuB.Text = "Вернуться к меню";
            this.returnToMenuB.UseVisualStyleBackColor = true;
            this.returnToMenuB.Click += new System.EventHandler(this.returnToMenuB_Click);
            // 
            // journalL
            // 
            this.journalL.AutoSize = true;
            this.journalL.Font = new System.Drawing.Font("Microsoft Sans Serif", 36F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.journalL.Location = new System.Drawing.Point(273, 17);
            this.journalL.Name = "journalL";
            this.journalL.Size = new System.Drawing.Size(189, 55);
            this.journalL.TabIndex = 44;
            this.journalL.Text = "Journal";
            // 
            // db2
            // 
            this.db2.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.db2.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.dataGridViewTextBoxColumn1,
            this.dataGridViewTextBoxColumn2});
            this.db2.Location = new System.Drawing.Point(437, 75);
            this.db2.Name = "db2";
            this.db2.Size = new System.Drawing.Size(294, 276);
            this.db2.TabIndex = 53;
            // 
            // dataGridViewTextBoxColumn1
            // 
            this.dataGridViewTextBoxColumn1.HeaderText = "id";
            this.dataGridViewTextBoxColumn1.Name = "dataGridViewTextBoxColumn1";
            this.dataGridViewTextBoxColumn1.Width = 50;
            // 
            // dataGridViewTextBoxColumn2
            // 
            this.dataGridViewTextBoxColumn2.HeaderText = "task";
            this.dataGridViewTextBoxColumn2.Name = "dataGridViewTextBoxColumn2";
            this.dataGridViewTextBoxColumn2.Width = 200;
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
            this.Column3.HeaderText = "specialization";
            this.Column3.Name = "Column3";
            // 
            // GiveTask
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.Controls.Add(this.db2);
            this.Controls.Add(this.db);
            this.Controls.Add(this.label9);
            this.Controls.Add(this.label8);
            this.Controls.Add(this.label7);
            this.Controls.Add(this.enterB);
            this.Controls.Add(this.taskIdB);
            this.Controls.Add(this.idTB);
            this.Controls.Add(this.returnToMenuB);
            this.Controls.Add(this.journalL);
            this.MaximizeBox = false;
            this.MinimizeBox = false;
            this.Name = "GiveTask";
            this.Text = "GiveTask";
            ((System.ComponentModel.ISupportInitialize)(this.db)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.db2)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.DataGridView db;
        private System.Windows.Forms.Label label9;
        private System.Windows.Forms.Label label8;
        private System.Windows.Forms.Label label7;
        private System.Windows.Forms.Button enterB;
        private System.Windows.Forms.TextBox taskIdB;
        private System.Windows.Forms.TextBox idTB;
        private System.Windows.Forms.Button returnToMenuB;
        private System.Windows.Forms.Label journalL;
        private System.Windows.Forms.DataGridView db2;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn1;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn2;
        private System.Windows.Forms.DataGridViewTextBoxColumn Column1;
        private System.Windows.Forms.DataGridViewTextBoxColumn Column2;
        private System.Windows.Forms.DataGridViewTextBoxColumn Column3;
    }
}