/*
###########################################################
### livesearch.js #########################################
### https://github.com/mjansma/LiveSearch/livesearch.js ###
### Copyright 2016 M.Jansma ###############################
###########################################################
 */
$.fn.liveSearch = function(config) {
	var table = $(config.table), children, searchString;
	$(this).keyup(function(){
		//Get all table columns
		children = table.find('td');
		searchString = $(this).val().toLowerCase();
		//Hide all rows except the for table header
		table.find('tr:gt(0)').hide();
		//Loop through all table columns
		children.each(function(index, child){
			//If search string matches table column
			if(child.innerHTML.toLowerCase().indexOf(searchString) != -1) {
				//Show table row
				$(child).closest('tr').show();
			};
		});
	});
};
