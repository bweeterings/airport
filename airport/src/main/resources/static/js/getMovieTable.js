function getData(){

    console.log("Getting data...");

    $.ajax({
        url: "http://localhost:8080/api/hotel/movie/all",
        type:"get",
        success: function(getMovie){

            console.log("returned from get:" + getMovie);

            $.each(getMovie,function(index, booking){
                console.log("Presenting movietable: ");
            });

            $("#DataTableMovie").DataTable().clear();
            $("#DataTableMovie").DataTable().rows.add(getMovie);
            $("#DataTableMovie").DataTable().columns.adjust().draw();
        }
    })
}

$(document).ready(function (){

    $("#DataTableMovie").DataTable({

        columns: [
           {"data": "id"},
           {"data": "movie.name"},
           {"data": "movie.author"},
        ]
    });

    getData();
});