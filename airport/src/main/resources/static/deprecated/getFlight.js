function getData() {

    $.ajax({

        url:"http://localhost8080/api/flights/all",
        type:"get",

        success: function(flights){

            $.each(movies, function(index, flight){
                $('#data').append(value.id + " " + "..." + " " + "<br>");
            });
        }
    });
}