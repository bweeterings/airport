function getData() {

    console.log("Getting data...");

    $.ajax({

        url:"http://localhost8080/api/flight/all",
        type:"get",

        success: function(flights){

            $.each(movies, function(index, flight){
                $('#data').append(value.id + " " + "..." + " " + "<br>");
            });
        }
    });
}