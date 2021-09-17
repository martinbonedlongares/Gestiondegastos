$(document).ready(function () {
  $("#busqueda").on("keyup", function () {
    var value = $(this).val().toLowerCase();
    $("#tablaMov tr").filter(function () {
      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1);
    });
  });
});

//Paginacion de la tabla
$(document).ready(function () {
  $("#tablaMov").DataTable({
    pagingType: "numbers",
  });
  $(".dataTables.length").addClass("bs-select");
});
