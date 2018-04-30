	var xhr = new XMLHttpRequest();
	
	var elements = document.getElementsByTagName('a');
	
	for (var i=0; i<elements.length; i++)	{				
		
 		var text = elements[i].textContent;
		
		elements[i].addEventListener('click', function() {
									
			var name = 'Gryffindor';
				
			xhr.open('GET', 'dashboard.json?team='+text, false);
			
			xhr.send();
			
		 	if (xhr.status != 200)
				{
				alert(xhr.status + ':' + xhr.statusText);
				}
			else {
				/* alert(JSON.parse(xhr.responseText)); */
				
				 var json = JSON.parse(xhr.responseText);
				
			 	 var table = document.createElement("table");
				
				 var tr = document.createElement('tr');
				 
				 var row1 = document.createElement('td');
				 row1.innerHTML = "First Name";
				 tr.appendChild(row1);
				 
				 var row2 = document.createElement('td');
				 row2.innerHTML = "Last Name";
				 tr.appendChild(row2);
				 
				 var row3 = document.createElement('td');
				 row3.innerHTML = "Nickname";
				 tr.appendChild(row3);
				 
				 var row4 = document.createElement('td');
				 row4.innerHTML = "Primary Skill";
				 tr.appendChild(row3);
				 
				 table.appendChild(tr);
				 
				 for(var developer in json.developers) {
					 
					 var developer = json[developer];				 
					 var tr = document.createElement('tr');
					 
					 var td1 = document.createElement('td');
					 td1.innerHTML = developer.firstName;
					 
					 var td2 = document.createElement('td');
					 td2.innerHTML = developer.lastName;
					 
					 var td3 = document.createElement('td');
					 td3.innerHTML = developer.nickname;
					 
					 var td4 = document.createElement('td');
					 td4.innerHTML = developer.primarySkill;
					 
					 table.appendChild(tr);
				 }
				 
				 document.body.appendChild(table);
			}  			
			
		})			
	}
	
	