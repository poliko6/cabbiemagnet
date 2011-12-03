<html>
<head>
<title>CabbieMagnet</title></head>
<body>
<h1>Welcome to CabbieMagnet!</h1>
<h2>List of services:</h2>
<ol>
<li><a href="companies">companies</a></li>
<li><a href="companies/{location}">companies/{location}</a></li>
<li><a href="customers">customers</a> - get all customers</li>
<li><a href="customers/new?id=_&name=_">customers/new</a> - new customer by ID, name is optional</li>
<li><a href="customers/{id}">customers/{id}</a> - retrieve customer by ID</li>
<li><a href="customers/change?id=_&name=_">customers/change</a> - change name for a given ID</li>
<li><a href="orders">orders</a> - list all the orders</li>
<li><a href="orders/customer/4521576567">rest/orders/customer/4521576567</a> - get orders for customer</li>
<li><a href="/orders/new?customer_id=4521576567&company_id=2&time_to_deliver=2011-11-14%2001:13:35&from_loc=Ostergade%2054&to_loc=vestergade">/orders/new</a> - create new order and INCLUDE JSON with cars</li>

</ol>
</body>
</html>