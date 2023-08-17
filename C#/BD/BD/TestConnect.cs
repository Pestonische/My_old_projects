using System;
using System.Collections.Generic;
using System.Data;
using System.Data.OleDb;
using System.Xml.Serialization;

namespace Example_OLEDB
{
    class TestConnect
    {
        public static List<string> number_orders = new List<string>();
        static void Main(string[] args)
        {
            // строка подключения
            string connectionString = "Provider=Microsoft.ACE.OLEDB.12.0;" + 
                                      "Data Source=online_shop12.accdb";       
           
            OleDbConnection connectAccess = null;
           
            // источник данных
            DataSet orderDataSet = new DataSet();
            DataSet order_structureDataSet = new DataSet();
            
            // адаптер данных для запроса на выборку
            OleDbDataAdapter adapterSel;
            
            // подключение к базе данных с использованием строки подключения
            try
            {
                connectAccess = new OleDbConnection(connectionString);
            }
            catch (Exception ex)
            {
                Console.WriteLine("ошибка подключения к базе данных:\n", ex.Message);
                return;
            }

            // формирование адаптера данных из результирующего набора строк запроса
            try
            {
                connectAccess.Open();

                adapterSel = new OleDbDataAdapter("select * FROM Заказ", connectAccess);          
                adapterSel.Fill(orderDataSet, "Заказ"); 

                adapterSel = new OleDbDataAdapter("select * FROM Состав_заказа", connectAccess);           
                adapterSel.Fill(order_structureDataSet, "Состав заказа");
               
                Console.WriteLine("Подключение открыто");
                // получение свойств подключения
                Console.WriteLine("Свойства подключения:");
                Console.WriteLine("\tСтрока подключения: {0}", connectAccess.ConnectionString);
                Console.WriteLine("\tБаза данных: {0}", connectAccess.Database);
                Console.WriteLine("\tСервер: {0}", connectAccess.DataSource);
                Console.WriteLine("\tПровайдер: {0}", connectAccess.Provider);
                Console.WriteLine("\tВерсия сервера: {0}", connectAccess.ServerVersion);
                Console.WriteLine("\tСостояние: {0}\n", connectAccess.State);
            }
            catch (Exception ex)
            {
                Console.WriteLine("ошибка! невозмпожно получить запрошенные данные\n", ex.Message);
                return;
            }
            finally
            {
                connectAccess.Close();
            }
            // отображение строк таблицы
            Console.WriteLine("\nИнформация о всех заказах со статусом «отказ», но с назначенным на заказ курьером: ");
            Orders(orderDataSet);
            Console.WriteLine("\nИнформация о составе этих заказов: ");
            Order_Structure(order_structureDataSet);

            connectAccess.Close();

            Console.WriteLine("\nПодключение закрыто");
        } 

        static void Orders(DataSet dt)
        {            
            DataRowCollection dtr = dt.Tables[0].Rows;
            Console.WriteLine("КодКлиента\t НомерЗаказа\t КодКурьера\t ДатаЗаказаt\t\t\t ДатаПоставки\t\t\t КодСостояния");
            foreach (DataRow dr in dtr)
            {
                if(dr[5].ToString() == "5" && dr[2].ToString()!="")
                {
                    for (int i = 0; i < dt.Tables[0].Columns.Count; i++)
                        Console.Write("{0}\t\t ", dr[i]);
                    Console.WriteLine();
                    number_orders.Add(dr[1].ToString());
                }
            }                 
        } 
        static void Order_Structure(DataSet dt)
        {
            DataRowCollection dtr = dt.Tables[0].Rows;
            Console.WriteLine("КодЗаписи\t КодТовара\t НомерЗаказа\t Количество\t Цена\t\t Заводской номер");
            foreach (DataRow dr in dtr)
            {
                if (dr[2].ToString() == number_orders[0])
                {
                    for (int i = 0; i < dt.Tables[0].Columns.Count; i++)
                        Console.Write("{0}\t\t ", dr[i]);
                    Console.WriteLine();
                    if(number_orders.Count>1)
                    number_orders.RemoveAt(0);
                }
            }           
        } 
    }
}