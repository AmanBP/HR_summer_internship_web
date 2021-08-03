var num_rows = 0;
var page = 0;
var APP = APP || {};
var tickedarr = [];
// Reload the page upon size change.
window.onresize=function(){
	location.reload();
}
// find number of rows that can fit in the column and fetch.
window.onload=findheight();
function findheight()
{
	console.log("HTML height = "+document.getElementById("mainpage").getBoundingClientRect().height);
	console.log("HTML height - approx = "+(document.getElementById("mainpage").getBoundingClientRect().height - 180));
	console.log("Approx number of rows = "+ Math.floor((document.getElementById("mainpage").getBoundingClientRect().height - 180)/35));
    num_rows = Math.floor((document.getElementById("mainpage").getBoundingClientRect().height - 180)/35);
    fetch();
}
function fetch()
{
    disable_left();
	//return $.getJSON("http://localhost:8080/H2HBABBA2705/FetchPaginated?index="+ page + "&offset=" + num_rows);
	var url = 'http://localhost:8080/H2HBABBA2705/FetchPaginated?index='+page*num_rows+'&offset='+num_rows;
    $.get(url, function(responseJson) { }).done(function(responseJson) {createtables(responseJson);})
}
function createtables(data)
{
   console.log(data);
   var table = document.getElementById("maintable");
   removeallchilds(table);
   table.append(document.createElement('colgroup'));
   /* <table id = maintable>
		<colgroup></colgroup>
		</table>
   */
   var colgroup0 = document.getElementsByTagName("colgroup")[0];
   widths=['3%','12%','10%','12%','12%','9%','15%','25%'];
   for(var i=0;i<8;i++)
   {
	   	colspan = document.createElement('col');
	  	colspan.style.width = widths[i];
		
	  	colgroup0.appendChild(colspan);
   }
   var tr = document.createElement('tr'); 
   table.appendChild(tr);
   tr0 = document.getElementsByTagName('tr')[0];
   headers = ["<img src=\"./images/check_box_empty.svg\">","Customer Name","Customer #","Invoice #","Invoice Amount","Due Date","Predicted Payment Date","Notes"];
   for(var i=0;i<8;i++){
	   td = document.createElement('td');
	   td.className = "table-headers"; 
	   td.innerHTML = headers[i];
	   tr0.appendChild(td);
   }
   var l = data.length;
   console.log(l);
   if(l == undefined)
   {
	   console.log("l is undefined");
	   tr = document.createElement('tr');
	   table.appendChild(tr);
	   tr1 = table.getElementsByTagName('tr')[1];
	   td = document.createElement('td');
	   td.className = "table-data";
	   td.innerHTML = "<img src=\"./images/check_box_empty.svg\">";
	   tr1.appendChild(td);
	   // For cname:
	   td = document.createElement('td');
	   td.className = "table-data";
	   td.innerHTML = String(data["cname"]);
	   tr1.appendChild(td);
	   // For cnum:
	   td = document.createElement('td');
	   td.className = "table-data";
	   td.innerHTML = String(data["cnum"]);
	   tr1.appendChild(td);
	   // For iid:
	   td = document.createElement('td');
	   td.className = "table-data";
	   td.innerHTML = String(data["iid"]);
	   tr1.appendChild(td);
	   // For checkbox:
	   td = document.createElement('td');
	   td.className = "table-data";
	   td.innerHTML = String(data["amount"]);
	   tr1.appendChild(td);
	   // For checkbox:
	   td = document.createElement('td');
	   td.className = "table-data";
	   td.innerHTML = String(data["due_date"]);
	   tr1.appendChild(td);
	   // For checkbox:
	   td = document.createElement('td');
	   td.className = "table-data";
	   if(typeof data["pred_date"] == 'undefined')
		   td.innerHTML = " -- ";
	   else
		   td.innerHTML = String(data["pred_date"]);
	   tr1.appendChild(td);
	   // For checkbox:
	   td = document.createElement('td');
	   td.className = "table-data";
	   if(data["notes"] == undefined || data["notes"] == null)
		   td.innerHTML = " -- ";
	   else
		   td.innerHTML = String(data["notes"]);
	   tr1.appendChild(td);
   }
   else{
   for(var i = 0;i < l;i++)
   {
	/* <table id = maintable>
			<colgroup>
		 		<col style = "width:i"> </col>
				 <col style = "width:i"> </col>
				 <col style = "width:i"> </col>
				 <col style = "width:i"> </col>
				 <col style = "width:i"> </col>
				 <col style = "width:i"> </col>
				 <col style = "width:i"> </col>
			</colgroup>
			<tr>
				   <td class="table-headers"> <img src=\"./images/check_box_empty.svg\"> </td>
				   // Followed by 7 more
			</tr>
			<tr>
				 <td class = "table-data"><img src=\"./images/check_box_empty.svg\"></td>
				 <td class = > finefi </td>
			</tr>

		</table>
   */
	   tofind = i+1;
	   tr = document.createElement('tr');
	   table.appendChild(tr);
	   console.log("tr added!" + i);
	   tr1 = document.getElementsByTagName('tr')[tofind];
	   // For checkbox:
	   td = document.createElement('td'); 
	   td.className = "table-data";
	   td.innerHTML = "<img src=\"./images/check_box_empty.svg\">";
	   tr1.appendChild(td);
	   // For cname:
	   td = document.createElement('td');
	   td.className = "table-data";
	   td.innerHTML = String(data[i]["cname"]);
	   tr1.appendChild(td);
	   // For cnum:
	   td = document.createElement('td');
	   td.className = "table-data";
	   td.innerHTML = String(data[i]["cnum"]);
	   tr1.appendChild(td);
	   // For iid:
	   td = document.createElement('td');
	   td.className = "table-data";
	   td.innerHTML = String(data[i]["iid"]);
	   tr1.appendChild(td);
	   // For checkbox:
	   td = document.createElement('td');
	   td.className = "table-data";
	   td.innerHTML = String(data[i]["amount"]);
	   tr1.appendChild(td);
	   // For checkbox:
	   td = document.createElement('td');
	   td.className = "table-data";
	   td.innerHTML = String(data[i]["due_date"]);
	   tr1.appendChild(td);
	   // For checkbox:
	   td = document.createElement('td');
	   td.className = "table-data";
	   if(typeof data[i]["pred_date"] == 'undefined') // or data[i]["pred_date"] == "undefined"
		   td.innerHTML = " -- ";
	   else
		   td.innerHTML = String(data[i]["pred_date"]);
	   tr1.appendChild(td);
	   // For checkbox:
	   td = document.createElement('td');
	   td.className = "table-data";
	   if(data[i]["notes"] == undefined || data[i]["notes"] == null)
		   td.innerHTML = " -- ";
	   else
		   td.innerHTML = String(data[i]["notes"]);
	   tr1.appendChild(td);
   }
   }
}
function next()
{
	page = page+1;
	fetch();
}
function previous()
{
	if(page != 0)
		page = page-1;
	fetch();
}
function disable_left(){
	left = document.getElementById('page-prev');
	if(page == 0)
	{
		left.disabled = true;
	}
	if(page>0)
	{
		left.disabled = false;
	}
}
function removeallchilds(element)
{
	console.log("Removing children of node"+element);
	const myNode = element;
	  while (myNode.firstChild) {
	    myNode.removeChild(myNode.lastChild);
	 }
}
function search()
{
	var iid = document.getElementsByClassName("search_box")[0].value;
	console.log("Search Clicked!! iid = "+iid);
	if(iid == "")
	{
		location.reload();
		return;
	}
	else{
	var url = 'http://localhost:8080/H2HBABBA2705/SearchServelet?iid='+iid;
    $.get(url, function(responseJson) {})
      .done(function(responseJson) {
        if(responseJson == "None"){
        	var table = document.getElementById("maintable");
        	removeallchilds(table);
        }
        else
        {
        	console.log("Got Data! :" + responseJson);
        	createtables(responseJson);
        }
      })
    }
}
function addtotickarr()
{
	
}
function properstring(date)
{
	//TODO create a date function!!!!
}
// function hideleft()
// function hideright()