$(document).ready(function() {
$('#select-update-race').on('change', function() {
  var raceId = this.value;
  $.ajax({
  		url : 'getRaceById',
  		type: 'GET',
  		dataType: 'JSON',
  		data : 'raceId='+raceId,
  		success: function(result){
  		    $('#id').val(result.id);
            $('#name').val(result.name);
            $('#city').val(result.city);

            var date = new Date(Date.parse(result.raceDate));
            var yyyy = date.getFullYear();
            var month = date.getMonth()+1;
            var mm = (month < 10 ? '0' : '' ) + month;
            var dayOfMonth = date.getDate();
            var dd = (dayOfMonth < 10 ? '0' : '' ) + dayOfMonth;

            $('#raceDate').val(mm+'/'+dd+'/'+yyyy);
            $('#photo').val(result.photo);

  		}
   });
});
});
