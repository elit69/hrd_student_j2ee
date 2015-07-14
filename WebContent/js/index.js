$(document).ready(function() {
  $('.selectpicker').selectpicker({ 
    'selectedText': '',
    style:'btn-default btn-lg',
    width:'auto'
  });
  $('#addressSearch').click(function(){
		$.post("listarticles.act", {
	        stu_name: searchObject.name(),
	        stu_class: searchObject.class(),
	        stu_status: searchObject.status()
	  	},	
	  	function(data, status){
	  		alert("n"+searchObject.name()+"\nc"+searchObject.class()+"\ns"+searchObject.status())
	  		//alert(searchObject);
	  		alert("Data: " + data + "\nStatus: " + status);
	  	}
	  );  	
	});
	var searchObject = {
    name: function(){	return $("#inputSearchName").val();},
    class: function(){
    	var getClassVal = $("#selectSearchTypeClass").val();
    	return getClassVal == "All Class" ? "" : getClassVal;
    },
    status: function(){
    	var getStatusVal = $("#selectSearchTypeStatus").val();
    	if(getStatusVal == "Active")			getStatusVal = 1;
    	else if (getStatusVal == "Inactive")	getStatusVal = 0;
    	else									getStatusVal = -1;
    	return getStatusVal;
    }
	};
});