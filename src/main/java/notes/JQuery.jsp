<!DOCTYPE html>
<html>
    <head>
        <title>Hello jQuery</title>
       <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script>
        $(document).ready(function() {
            $.ajax({
                url: "http://localhost:8090/RESTFreshers/oneemployee",
                type:'GET',
                contentType:'application/json'
            }).then(function(data) {
               $('.employeeNo').append(data.employeeNumber);
               $('.employeeName').append(data.employeeName);
            });
        });
        
        </script>
    </head>
    <body>
        <div>
            <p class="employeeNo">  Employee number from RESTFul  : </p>
            <p class="employeeName"> Employee name from RESTFul  : </p>
        </div>
    </body>
</html>
    
