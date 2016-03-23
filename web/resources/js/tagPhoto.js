    $('#mark-save-btn').on('click', function () {

    var marksArr = [];
    $('.added-marks-ul .added-mark').text();
        $('#added-marks-ul .added-mark').each(function(){
        marksArr.push($(this).text())
        });

    myJSON = {
                    photoID : $('.caption-container .caption').text(),
                    marks : JSON.stringify( marksArr )
                };


	$.ajax({
		url : 'setMarkInPhoto',
		type: 'GET',
		dataType: 'text',
		data : myJSON,
		success: function(result){

		          if(result){
$('#save-mark').append('<div class="alert alert-success" role="alert">Marks saved!</div>');
                     }
                     else{

                     }
                   }
	});
        });

    function addMark(id){

            $.ajax({
                url : 'getMarkInPhoto',
                type: 'GET',
                dataType: 'JSON',
                data : {'id' : id} ,
                success: function(result){

    $('#added-marks-ul li').remove();
    for(i=0 ; i < result.length; i++ ){
     $('#added-marks-ul').prepend("<li class='added-mark'>"+result[i].number+"<button class='btn btn-primary' style='float:right'><span class='glyphicon glyphicon-remove-circle' aria-hidden='true' ></span></button></li>");
    }

                  }
            });

    $('div#save-mark .alert.alert-success').remove();
        }

//$('.added-marks-ul .added-mark')

        $('#add-mark-btn').on('click',function(){
    if ($('#add-mark-number').val() === ""){return};
    $('#added-marks-ul').prepend("<li class='added-mark'>"+$('#add-mark-number').val()+"<button class='btn btn-primary' style='float:right'><span class='glyphicon glyphicon-remove-circle' aria-hidden='true' ></span></button></li>");
    $('#add-mark-number').val('');

    });

            $('#added-marks-ul').on('click','.btn-primary',function(){
    $(this).parent().remove()
    });



    $('form .btn-primary').on('click', function () {
	$(this).children().prop( "checked", true) ;
	$('#marks-select-form').submit();
        });




