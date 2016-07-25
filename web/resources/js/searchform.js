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
    }
});
