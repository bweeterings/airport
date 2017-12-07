/* when first opened initially load tiles for dashboard */
$(document).ready(function(){
    changeContent("views/tiles.html");
});

/* on click switches main content e.i. dashboard to overview and vice versa */
function changeContent(url){
    $('#page').empty();
    $('#page').load(url);
}

/*  Load a modal into a certain id. */
function loadModal(url, id){
    $(id).empty();
    $(id).load(url);
}