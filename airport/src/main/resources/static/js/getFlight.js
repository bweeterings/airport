function getFlightData(){

    $.ajax({
        url: "http://localhost:8080/api/flights/all",
        type:"get",
        success: function(response){

           $("#flightTable").DataTable().clear();
           $("#flightTable").DataTable().rows.add(response);
           $("#flightTable").DataTable().columns.adjust().draw();
        }
    });
}

$(document).ready(function(){
    $('#flightTable').DataTable({
        select:{
            style: 'os',
            selector: 'td:first-child'
        },
        order:[[1,'asc']],
        columns: [

            {"defaultContent": "" },
            {"data": "id"},
            {"data": "airplane"},
            {"data": "origin"}
            {"data": "destination"}
            {"data": "fuelCost"}
        ],
    });
    getFlightData();
});