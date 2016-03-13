$('#race-input-search').autocomplete({
	serviceUrl: 'getRace',
	paramName: "raceName",
	delimiter: ",",
	transformResult: function(response) {
	    return {
            suggestions: $.map($.parseJSON(response), function(item) {
                return { value: item.name };
	         })
	    };
    },
    onSelect: function () {checkRace()}
});
$('#runner-input-search').autocomplete({
	serviceUrl: 'getRunner',
	paramName: "runnerSurnameAndName",
	delimiter: ",",
	transformResult: function(response) {
		return {
			suggestions: $.map($.parseJSON(response), function(item) {
				return { value: item.surname+" "+item.name };
			})
		};
	},

});

    var inputRace = document.getElementById('race-input-search');
	var inputNumber = document.getElementById('number-input-search');

    inputRace.oninput = function(){checkRace()};
    inputNumber.oninput = function(){checkRace()};


function checkRace(){

    var button = document.getElementById('search-btn');

	$.ajax({
		url : 'checkRaceAndNumber',
		type: 'GET',
		dataType: 'text',
		data : ({
			race: inputRace.value,
			number: inputNumber.value
		}),
		success: function(result){

		          if(result){
		            button.className="sbtn btn btn-orange";
		            button.onclick = function(){
		            inputRace.value=result;
                    document.getElementById('search-form').submit();
                    return false;
		            }
                     }
                     else{
                    button.className="sbtn sbtn-d btn btn-orange"
                     }
                   }
	});
}


