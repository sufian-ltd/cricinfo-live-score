$(document).ready(function () {
  $('#dataTable').DataTable({
      dom: '<"pull-left"f><"pull-right"l>tip',
      language: {
          search: "",
          searchPlaceholder: "Search"
      },
  });
});