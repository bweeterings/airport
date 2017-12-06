function postNewMovie(){

   var titleOfNewMovie = $('#title').val();
   console.log("Entered text in input is:" + titleOfNewMovie);

   var newMovie = {
   title : titleOfNewMovie,
            author : "jemoeder",
   };

   console.log(newMovie);

   var validJsonBook = JSON.stringify(newMovie);
   console.log(validJsonBook);

   $.ajax({
       url:"http://localhost8080/api/movie/add",
       type:"post",
       data: validJsonBook,
       contentType: "application/json",
       success: function(result) {
            console.log("success post data!");
            getData();
       }
   });
}