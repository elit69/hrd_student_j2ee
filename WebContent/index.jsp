<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <meta name="author" content="Chhorn Elit">
  <meta lang="en">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  
  <!-- CSS Library -->
  <link rel="stylesheet" href="css/lib/bootstrap.min.css" />
  <link rel="stylesheet" href="css/lib/font-awesome-4.3.0/css/font-awesome.min.css">
  <!-- End CSS Library -->

  <!-- Custom StyleSheet --> 
  <link rel="stylesheet" href="css/index.css">
  <!-- End Custom StyleSheet --> 

  <!-- Javascript Library -->
  <script src="js/lib/jquery-2.1.4.min.js"></script>    
  <script src="js/lib/bootstrap.min.js"></script>
  <!-- End Javascript Library -->
  
  <!-- Custom Javascript --> 
  <script src="js/index.js"></script>
  <!-- End Custom Javascript -->
</head>
<body>
  <div id="main" class="container-fluid">
    <div class="row col-sm-11 center-block">
      <div class="col-sm-12 card form-horizontal"> 
        
          <h1>Add New</h1>
          <hr> 
          <div class="col-sm-12 input-group">
            <div class="col-sm-5">
              <div class="form-group">
                  <label class="col-sm-3">ID:</label>
                  <div class="col-sm-9">
                      <input type="number" id="inputId" class="form-control" name="id" placeholder="Enter ID" disabled style="cursor:alias;">
                  </div>
              </div>              
              <div class="form-group">
                  <label class="col-sm-3">Name:</label>
                  <div class="col-sm-9">
                      <input type="text" id="inputName" class="form-control" name="name" placeholder="Enter Name"> </div>
              </div>
              <div class="form-group ">
                <label class="col-sm-3">Gender:</label>
                <div class="col-sm-9 gender">
                  <span class="col-sm-2"></span>
                  <span class="col-sm-4">
                    <input type="radio" id="inputGenderMale" name="gender" value="male" data-fv-field="gender" checked> Male
                  </span>
                  <span class="col-sm-5">
                    <input type="radio" id="inputGenderFemale" name="gender" value="female" data-fv-field="gender"> Female
                  </span>
                </div>
              </div>  
            </div>
            <div class="col-sm-1"></div>
            <div class="col-sm-5">
              <div class="form-group">
                  <label class="col-sm-3">University: </label>
                  <div class="col-sm-9">
                      <input type="text" id="inputUniversity" name="city" class="form-control" placeholder="Enter University"> </div>
              </div>
              <div class="form-group">
                  <label class="col-sm-3">Class: </label>
                  <div class="col-sm-9">
                      <input type="text" id="inputClass" name="city" class="form-control" placeholder="Enter Class"> </div>
              </div>
              <div class="form-group ">
                <label class="col-sm-3">Status:</label>
                <div class="col-sm-9 gender">
                  <span class="col-sm-2"></span>
                  <span class="col-sm-4">
                    <input type="radio" id="inputStatusActive" name="status" value="active" checked> Active
                  </span>
                  <span class="col-sm-5">
                    <input type="radio" id="inputStatusInactive" name="status" value="inactive"> Inactive
                  </span>
                </div>
              </div>                   
            </div>            
          </div>
          <div class="col-sm-3"></div>
          <div class="col-sm-6">
            <div class="form-group">    
              <button id="btnAdd" class="btn btn-primary" style="width:200px;">
              <i class="fa fa-plus-circle"></i>&nbsp;&nbsp;Add User</button>
              <button id="btnClear" class="btn btn-primary pull-right" style="width:200px;">
              <i class="fa fa-times-circle"></i>&nbsp;&nbsp;Clear</button>
              </button>
            </div>
          </div>  
        
      </div>
      <div class="col-sm-12 card"> 
        <div class="col-sm-12">
          <h1>Search</h1>
          <hr> 
          <form role="form" class="col-sm-12 search-bar">
            <!-- Search Button -->
            <div class="col-sm-8">
              <input id="inputSearchName" type="textbox" placeholder="Enter Name " class="form-control input-lg">
            </div> 
            <!-- End Search Button -->

            <!-- Search Type Select -->
            <div class="col-sm-2">
              <div class="form-group" >
                <select name="Type" class="selectpicker" id="selectSearchTypeClass" >
                  <option class="active">All Class</option>
                  <option>PP</option>
                  <option>BTB</option>
                  <option>SR</option>
                </select>
              </div>               
            </div>        
            <!-- End Search Type Select -->       
            <div class="col-sm-2">
              <div class="form-group" >
                <select name="Type" class="selectpicker" id="selectSearchTypeStatus" >
                  <option class="active">All Status</option>
                  <option>Active</option>
                  <option>Inactive</option>
                </select>
              </div>               
            </div>       
          </form>             
          <!-- Table User List -->
          <div class="table-responsive">       
            <table class="table table-striped table-hover">
              <thead>
                <tr class="info">
                  <th>ID</th>
                  <th>Name</th>
                  <th>Gender</th>
                  <th>University</th>
                  <th>Class</th>
                  <th>Status</th>
                  <th>Action</th>
                </tr>
              </thead>
              <tbody>
                                                 
              </tbody>      

            </table> 
          </div>
          <!-- End Table User List -->    
        </div> 
      </div>
    </div>
  </div>
</body>
</html>