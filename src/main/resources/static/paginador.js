function Pager(tableName, itemsPerPage) {
  "use strict";

  this.tableName = tableName;
  this.itemsPerPage = itemsPerPage;
  this.currentPage = 1;
  this.pages = 0;
  this.inited = false;

  this.showRecords = function (from, to) {
    let rows = document.getElementById(tableName).rows;

    // i starts from 1 to skip table header row
    for (let i = 1; i < rows.length; i++) {
      if (i < from || i > to) {
        rows[i].style.display = "none";
      } else {
        rows[i].style.display = "";
      }
    }
  };

  this.showPage = function (pageNumber) {
    if (!this.inited) {
      // Not initialized
      return;
    }

    let oldPageAnchor = document.getElementById("pg" + this.currentPage);
    oldPageAnchor.className = "pg-normal";

    this.currentPage = pageNumber;
    let newPageAnchor = document.getElementById("pg" + this.currentPage);
    newPageAnchor.className = "pg-selected";

    let from = (pageNumber - 1) * itemsPerPage + 1;
    let to = from + itemsPerPage - 1;
    this.showRecords(from, to);
  };

  this.prev = function () {
    if (this.currentPage > 1) {
      this.showPage(this.currentPage - 1);
    }
  };

  this.next = function () {
    if (this.currentPage < this.pages) {
      this.showPage(this.currentPage + 1);
    }
  };

  this.init = function () {
    let rows = document.getElementById(tableName).rows;
    let records = rows.length - 1;

    this.pages = Math.ceil(records / itemsPerPage);
    this.inited = true;
  };

  this.showPageNav = function (pagerName, positionId) {
    if (!this.inited) {
      // Not initialized
      return;
    }

    let element = document.getElementById(positionId),
      pagerHtml =
        '<span onclick="' +
        pagerName +
        '.prev();" class="pg-normal pg-prev">&#171;</span>';

    for (let page = 1; page <= this.pages; page++) {
      pagerHtml +=
        '<span id="pg' +
        page +
        '" class="pg-normal pg-next" onclick="' +
        pagerName +
        ".showPage(" +
        page +
        ');">' +
        page +
        "</span>";
    }

    pagerHtml +=
      '<span onclick="' +
      pagerName +
      '.next();" class="pg-normal">&#187;</span>';

    element.innerHTML = pagerHtml;
  };
}
let pager = new Pager("pager", 10);

pager.init();
pager.showPageNav("pager", "pageNavPosition");
pager.showPage(1);

//Esta función filtra los elementos en pantalla
function filtrar() {
  // Declare variables
function Pager(tableName, itemsPerPage) {
  "use strict";

  this.tableName = tableName;
  this.itemsPerPage = itemsPerPage;
  this.currentPage = 1;
  this.pages = 0;
  this.inited = false;

  this.showRecords = function (from, to) {
    let rows = document.getElementById(tableName).rows;

    // i starts from 1 to skip table header row
    for (let i = 1; i < rows.length; i++) {
      if (i < from || i > to) {
        rows[i].style.display = "none";
      } else {
        rows[i].style.display = "";
      }
    }
  };

  this.showPage = function (pageNumber) {
    if (!this.inited) {
      // Not initialized
      return;
    }

    let oldPageAnchor = document.getElementById("pg" + this.currentPage);
    oldPageAnchor.className = "pg-normal";

    this.currentPage = pageNumber;
    let newPageAnchor = document.getElementById("pg" + this.currentPage);
    newPageAnchor.className = "pg-selected";

    let from = (pageNumber - 1) * itemsPerPage + 1;
    let to = from + itemsPerPage - 1;
    this.showRecords(from, to);
  };

  this.prev = function () {
    if (this.currentPage > 1) {
      this.showPage(this.currentPage - 1);
    }
  };

  this.next = function () {
    if (this.currentPage < this.pages) {
      this.showPage(this.currentPage + 1);
    }
  };

  this.init = function () {
    let rows = document.getElementById(tableName).rows;
    let records = rows.length - 1;

    this.pages = Math.ceil(records / itemsPerPage);
    this.inited = true;
  };

  this.showPageNav = function (pagerName, positionId) {
    if (!this.inited) {
      // Not initialized
      return;
    }

    let element = document.getElementById(positionId),
      pagerHtml =
        '<span onclick="' +
        pagerName +
        '.prev();" class="pg-normal pg-prev">&#171;</span>';

    for (let page = 1; page <= this.pages; page++) {
      pagerHtml +=
        '<span id="pg' +
        page +
        '" class="pg-normal pg-next" onclick="' +
        pagerName +
        ".showPage(" +
        page +
        ');">' +
        page +
        "</span>";
    }

    pagerHtml +=
      '<span onclick="' +
      pagerName +
      '.next();" class="pg-normal">&#187;</span>';

    element.innerHTML = pagerHtml;
  };
}
let pager = new Pager("pager", 10);

pager.init();
pager.showPageNav("pager", "pageNavPosition");
pager.showPage(1);

//Esta función filtra los elementos en pantalla
function filtrar() {
  // Declare variables

  var input, filter, table, tr, td, i, txtValue;
  input = document.getElementById("myInput");
  filter = input.value.toUpperCase();
  table = document.getElementById("pager");
  tr = table.getElementsByTagName("tr");

  for (i = 0; i < tr.length; i++) {
    td = tr[i].getElementsByTagName("td")[0];
    if (td) {
      txtValue = td.textContent || td.innerText;
      if (txtValue.toUpperCase().indexOf(filter) > -1) {
        tr[i].style.display = "";
      } else {
        tr[i].style.display = "none";
      }
=======
  var input, filter, table, tr, td, i, j;
  input = document.getElementById("myInput");
  filter = input.value.toUpperCase();
  table = document.getElementById("pager");
  tr = table.getElementsByTagName("tr");

  for (i = 0; i < tr.length; i++) {
    td = tr[i].getElementsByTagName("td");
    for(j=0;j<td.length;j++){
        let tdata=td[j];
        if(tdata){
            if(tdata.innerHTML.toUpperCase().indexOf(filter)>-1){
                tr[i].style.display="";
                break;
            }else{
                tr[i].style.display="none";
            }
        }
  var input, filter, table, tr, td, i, j;
  input = document.getElementById("myInput");
  filter = input.value.toUpperCase();
  table = document.getElementById("pager");
  tr = table.getElementsByTagName("tr");

  for (i = 0; i < tr.length; i++) {
    td = tr[i].getElementsByTagName("td");
    for(j=0;j<td.length;j++){
        let tdata=td[j];
        if(tdata){
            if(tdata.innerHTML.toUpperCase().indexOf(filter)>-1){
                tr[i].style.display="";
                break;
            }else{
                tr[i].style.display="none";
            }
        }
    }
  }
}

/* Esto funciona pero con los ID predefinidos (Es una prueba) */
function mostrarFormularioNuevoMovimiento(codigoparam, idGrupo) {
  $.ajax({
    url: "/gestion/grupo/"+idGrupo+"/nuevoMovimiento?idUsuarioGrupo=7&idGrupo=6",
    data: {
      codigo: codigoparam,
    },
    success: function (formularioEditar) {
      bootbox.dialog({
        message: formularioEditar,
      });
    },
    error: function (err) {
      alert("Si la URL esta mal. Codigo 404");
    },
  });
}
  
function mostrarMiembrosGrupo(idGrupo) {
    $.ajax({
    url: idGrupo+"/gestionar",
    success: function (formularioEditar) {
      bootbox.dialog({
        message: formularioEditar,
      });
    },
    error: function (err) {
      alert("Si la URL esta mal. Codigo 404");
    },
  });
}