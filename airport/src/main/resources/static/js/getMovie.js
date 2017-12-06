function getData() {

    console.log("Getting data...");

    $.ajax({

        url:"http://localhost8080/api/movie/all",
        type:"get",

        success: function(movies){

            console.log("This is the data: " + movies);

            $.each(movies, function(index, movie){
                console.log(movie.id + " " + movie.title + " " + movie.author);
                $('#data').append(value.id + " " + value.title + " " + value.author + "<br>");
            });
        }
    });
}