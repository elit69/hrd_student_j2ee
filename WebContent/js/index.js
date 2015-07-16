$(document).ready(function() {
//  $('.selectpicker').selectpicker({ 
//    'selectedText': '',
//    style:'btn-default btn-lg',
//    width:'auto'
//  });
    $('#btnAdd').click(function(){
        if( studentObject.id() ==  "" || 
            studentObject.name() ==  "" ||
            studentObject.university() ==  "" ||
            studentObject.stu_class() ==  ""){
            alert("false a alsdf");
            return;
        }
    });
    $('#inputSearchName').on('input', function(){
		$.post("searchstudents.act", {
    	        stu_name: searchObject.name(),
    	        stu_class: searchObject.class(),
    	        stu_status: searchObject.status()
    	  	},	
    	  	function(json, status){
                $("tbody").empty();
                if(json.length > 0) {
                    $("tbody").append(listResult(json));
                    return;
                }
                showErrorSearch();
    	  	}
	    );  	
    // insertstudent.act
    // updatestudent.act
    // deletestudent.act
	});
    function listResult(json){
        var str;
        for(var i=0; i<json.length; i++){
            var status = json[i].stu_status == 1 ? 
                    "<button  class='btn btn-success btn-sm' >" +
                        "<i class='fa fa-check'></i>&nbsp;&nbsp;Active" +
                    "</button>"
                    :
                    "<button  class='btn btn-warning btn-sm' >" +
                        "<i class='fa fa-times'></i>&nbsp;&nbsp;Inactive" +
                    "</button>";
            var gender = json[i].stu_gender == 1 ? "Male" : "Female";
            str += 
                "<tr>" +
                  "<td>" + json[i].stu_id + "</td>" + 
                  "<td>" + json[i].stu_name + "</td>" + 
                  "<td>" + gender + "</td>" +                   
                  "<td>" + json[i].stu_university + "</td>" +  
                  "<td>" + json[i].stu_class + "</td>" +  
                  "<td>" + status + "</td>" + 
                  "<td>" + 
                    "<button  class='btn btn-info btn-sm'><i class='fa fa-pencil'></i>&nbsp;&nbsp;Edit</button> " +
                    "<button  class='btn btn-danger btn-sm'><i class='fa fa-trash'></i>&nbsp;&nbsp;Delete</button> " +
                  "</td>" + 
                "</tr>";
        }      
        return str;  
    }
    function showErrorSearch(){
        $("tbody").append(
            "<tr>" +
                "<td class='alert alert-danger'  colspan=7 style='padding:80px!important'>" +
                    "<center>" +
                      "<strong>Not Found!</strong> Please Search Again!" +
                    "</center>" +
                "</td>" +
            "</tr>"                    
        );
    }
	var searchObject = {
        name: function(){	return $("#inputSearchName").val();   },
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
    var studentObject = {
        id: function(){   return $("#inputId").val();   },
        name: function(){   return $("#inputName").val();   },
        university: function(){   return $("#inputUniversity").val();   },
        stu_class: function(){   return $("#inputClass").val();   },        
        gender: function(){   return $("#inputGenderMale").is(':checked') == true ? 1 : 0;     },
        status1: function(){   return $("#inputStatusActive").is(':checked') == true ? 1 : 0;    }
        //toString: function(){   }
    }
    //alert(studentObject.id() + "\n" + studentObject.name() + "\n" + studentObject.university() + "\n" + studentObject.stu_class() + "\n" + studentObject.gender() + "\n" + studentObject.status1() + "\n" ); 
});