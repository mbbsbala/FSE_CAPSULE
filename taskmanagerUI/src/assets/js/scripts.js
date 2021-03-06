$( function() {
    $( "#startDatePicker" ).datepicker();
  } );

  $( function() {
    $( "#endDatePicker" ).datepicker();
  } );

  $( function() {
    var handle = $( "#custom-handle" );
    $( "#slider" ).slider({
      range: true,
      min: 0,
      max: 30,
      create: function() {
        handle.text( $( this ).slider( "value" ) );
      },
      slide: function( event, ui ) {
        handle.text( ui.value );
      }
    });
  } );

  
angular
  .module('taskmanagerApp', ['ngMaterial'])
  .controller('addsliderController', addsliderController)
  .controller('updatesliderController', updatesliderController);

function addsliderController ($scope, $mdSidenav) {
  $scope.color = {
     grey: 15
  };
}   
function updatesliderController ($scope, $mdSidenav) {
  $scope.color = {
     grey: 15
  };
}     