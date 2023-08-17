namespace PPS_Lab
{
    partial class SubmitTask
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
            this.taskTB = new System.Windows.Forms.TextBox();
            this.enterB = new System.Windows.Forms.Button();
            this.cancelB = new System.Windows.Forms.Button();
            this.idTB = new System.Windows.Forms.TextBox();
            this.label2 = new System.Windows.Forms.Label();
            this.db = new System.Windows.Forms.DataGridView();
            this.Column2 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.Column4 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.Column1 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.journalL = new System.Windows.Forms.Label();
            ((System.ComponentModel.ISupportInitialize)(this.db)).BeginInit();
            this.SuspendLayout();
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Microsoft Sans Serif", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.label1.Location = new System.Drawing.Point(44, 356);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(425, 25);
            this.label1.TabIndex = 0;
            this.label1.Text = "Введите ссылку с заданием и ID задания";
            // 
            // taskTB
            // 
            this.taskTB.Font = new System.Drawing.Font("Microsoft Sans Serif", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.taskTB.Location = new System.Drawing.Point(49, 384);
            this.taskTB.Name = "taskTB";
            this.taskTB.Size = new System.Drawing.Size(350, 31);
            this.taskTB.TabIndex = 1;
            this.taskTB.TextChanged += new System.EventHandler(this.taskTB_TextChanged);
            // 
            // enterB
            // 
            this.enterB.Font = new System.Drawing.Font("Microsoft Sans Serif", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.enterB.Location = new System.Drawing.Point(609, 377);
            this.enterB.Name = "enterB";
            this.enterB.Size = new System.Drawing.Size(122, 45);
            this.enterB.TabIndex = 2;
            this.enterB.Text = "Enter";
            this.enterB.UseVisualStyleBackColor = true;
            this.enterB.Click += new System.EventHandler(this.enterB_Click);
            // 
            // cancelB
            // 
            this.cancelB.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.cancelB.Location = new System.Drawing.Point(698, 12);
            this.cancelB.Name = "cancelB";
            this.cancelB.Size = new System.Drawing.Size(90, 27);
            this.cancelB.TabIndex = 3;
            this.cancelB.Text = "Вернуться к меню";
            this.cancelB.UseVisualStyleBackColor = true;
            this.cancelB.Click += new System.EventHandler(this.cancelB_Click);
            // 
            // idTB
            // 
            this.idTB.Font = new System.Drawing.Font("Microsoft Sans Serif", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.idTB.Location = new System.Drawing.Point(475, 384);
            this.idTB.Name = "idTB";
            this.idTB.Size = new System.Drawing.Size(100, 31);
            this.idTB.TabIndex = 4;
            this.idTB.TextChanged += new System.EventHandler(this.idTB_TextChanged);
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Font = new System.Drawing.Font("Microsoft Sans Serif", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.label2.Location = new System.Drawing.Point(437, 384);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(32, 25);
            this.label2.TabIndex = 5;
            this.label2.Text = "ID";
            // 
            // db
            // 
            this.db.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.db.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.Column2,
            this.Column4,
            this.Column1});
            this.db.Location = new System.Drawing.Point(169, 83);
            this.db.Name = "db";
            this.db.Size = new System.Drawing.Size(445, 260);
            this.db.TabIndex = 54;
            // 
            // Column2
            // 
            this.Column2.HeaderText = "id";
            this.Column2.Name = "Column2";
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
            // journalL
            // 
            this.journalL.AutoSize = true;
            this.journalL.Font = new System.Drawing.Font("Microsoft Sans Serif", 36F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.journalL.Location = new System.Drawing.Point(290, 25);
            this.journalL.Name = "journalL";
            this.journalL.Size = new System.Drawing.Size(189, 55);
            this.journalL.TabIndex = 53;
            this.journalL.Text = "Journal";
            // 
            // SubmitTask
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.Controls.Add(this.db);
            this.Controls.Add(this.journalL);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.idTB);
            this.Controls.Add(this.cancelB);
            this.Controls.Add(this.enterB);
            this.Controls.Add(this.taskTB);
            this.Controls.Add(this.label1);
            this.MaximizeBox = false;
            this.MinimizeBox = false;
            this.Name = "SubmitTask";
            this.Text = "SubmitTask";
            ((System.ComponentModel.ISupportInitialize)(this.db)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.TextBox taskTB;
        private System.Windows.Forms.Button enterB;
        private System.Windows.Forms.Button cancelB;
        private System.Windows.Forms.TextBox idTB;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.DataGridView db;
        private System.Windows.Forms.DataGridViewTextBoxColumn Column2;
        private System.Windows.Forms.DataGridViewTextBoxColumn Column4;
        private System.Windows.Forms.DataGridViewTextBoxColumn Column1;
        private System.Windows.Forms.Label journalL;
    }
}