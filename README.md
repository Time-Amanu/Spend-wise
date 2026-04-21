# Spend-wise
A freely available API that you can use to track your record expenses, view history, Financial insights and categorization

Basic Documentaion
Method,Endpoint,Description,Example JSON Request
  GET,/api/expenses,Get all expenses,None
  POST,/api/expenses,Add a new expense,"{""description"": ""Rent"", ""amount"": 500.0, ""category"": ""Housing"", ""date"": ""2026-03-18""}"
  GET,/api/expenses/total,Get sum of all spending,None (Returns a Number)
  GET,/api/expenses/category/{name},Filter by category,None
  PUT,/api/expenses/{id},Update an expense,Same as POST
  DELETE,/api/expenses/{id},Remove an expense,None
