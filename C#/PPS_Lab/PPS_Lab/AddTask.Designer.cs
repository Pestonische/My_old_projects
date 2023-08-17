namespace PPS_Lab
{
    partial class AddTask
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
            this.cancelB = new System.Windows.Forms.Button();
            this.createTaskB = new System.Windows.Forms.Button();
            this.taskTB = new System.Windows.Forms.TextBox();
            this.label1 = new System.Windows.Forms.Label();
            this.deadlineTB = new System.Windows.Forms.TextBox();
            this.label2 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.SuspendLayout();
            // 
            // cancelB
            // 
            this.cancelB.Font = new System.Drawing.Font("Microsoft Sans Serif", 21.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.cancelB.Location = new System.Drawing.Point(592, 368);
            this.cancelB.Name = "cancelB";
            this.cancelB.Size = new System.Drawing.Size(151, 44);
            this.cancelB.TabIndex = 0;
            this.cancelB.Text = "Cancel";
            this.cancelB.UseVisualStyleBackColor = true;
            this.cancelB.Click += new System.EventHandler(this.cancelB_Click);
            // 
            // createTaskB
            // 
            this.createTaskB.Font = new System.Drawing.Font("Microsoft Sans Serif", 21.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.createTaskB.Location = new System.Drawing.Point(66, 368);
            this.createTaskB.Name = "createTaskB";
            this.createTaskB.Size = new System.Drawing.Size(151, 44);
            this.createTaskB.TabIndex = 0;
            this.createTaskB.Text = "Create";
            this.createTaskB.UseVisualStyleBackColor = true;
            this.createTaskB.Click += new System.EventHandler(this.createTaskB_Click);
            // 
            // taskTB
            // 
            this.taskTB.Font = new System.Drawing.Font("Microsoft Sans Serif", 21.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.taskTB.ImeMode = System.Windows.Forms.ImeMode.NoControl;
            this.taskTB.Location = new System.Drawing.Point(66, 223);
            this.taskTB.Name = "taskTB";
            this.taskTB.ScrollBars = System.Windows.Forms.ScrollBars.Horizontal;
            this.taskTB.Size = new System.Drawing.Size(677, 40);
            this.taskTB.TabIndex = 1;
            this.taskTB.TextChanged += new System.EventHandler(this.taskTB_TextChanged);
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Microsoft Sans Serif", 26.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.label1.Location = new System.Drawing.Point(208, 149);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(392, 39);
            this.label1.TabIndex = 2;
            this.label1.Text = "Введите текст задания";
            // 
            // deadlineTB
            // 
            this.deadlineTB.Font = new System.Drawing.Font("Microsoft Sans Serif", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.deadlineTB.Location = new System.Drawing.Point(251, 292);
            this.deadlineTB.Name = "deadlineTB";
            this.deadlineTB.Size = new System.Drawing.Size(126, 31);
            this.deadlineTB.TabIndex = 3;
            this.deadlineTB.TextChanged += new System.EventHandler(this.deadlineTB_TextChanged);
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Font = new System.Drawing.Font("Microsoft Sans Serif", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.label2.Location = new System.Drawing.Point(66, 298);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(150, 25);
            this.label2.TabIndex = 4;
            this.label2.Text = "Крайний срок";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Font = new System.Drawing.Font("Microsoft Sans Serif", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.label3.Location = new System.Drawing.Point(396, 295);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(166, 25);
            this.label3.TabIndex = 5;
            this.label3.Text = "год-месяц-день";
            // 
            // AddTask
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.deadlineTB);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.taskTB);
            this.Controls.Add(this.createTaskB);
            this.Controls.Add(this.cancelB);
            this.MaximizeBox = false;
            this.MinimizeBox = false;
            this.Name = "AddTask";
            this.Text = "AddTask";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Button cancelB;
        private System.Windows.Forms.Button createTaskB;
        private System.Windows.Forms.TextBox taskTB;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.TextBox deadlineTB;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label3;
    }
}