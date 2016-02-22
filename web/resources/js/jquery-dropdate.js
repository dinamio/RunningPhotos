/*
 * Jquery DropDown Date v1.0
 * https://github.com/luonghuycuong/jquery-dropdate
 * 
 */
(function ( $, window, document, undefined ) {

	var name = "dropdate",
    defaults = {
		minYear:1970,
		maxYear:new Date().getFullYear(),
		format:'yyyy/mm/dd',
		className:'dropdate-select',
		defaultDate:new Date()
    };

	function genselect(from, to, defaultValue){
		var str = '<select>';
		if(defaultValue){
			str += '<option value="">'+defaultValue+'</option>';
		}
		for(var i = from; i <= to; i++){
			str += '<option value="'+i+'">'+i+'</option>';
		}
		str += '</select>';
		return str;
	}
	
	function dropdate(el, options) {
		
		var s = this;

        s.opts = $.extend( {}, defaults, options );
        s.elem = $(el);

        init();

        function init(){

        	var d = s.elem.val();
        	d = d ? d : s.opts.defaultDate;
        	
        	s.opts.day = $(genselect(1, 31, 'Day'));
        	s.opts.month = $(genselect(1, 12, 'Month'));
        	s.opts.year = $(genselect(s.opts.minYear, s.opts.maxYear, 'Year'));
        	
			var date = Date.parse(d);
			if(isNaN(date)){
				date = new Date();
			} else{
				var date = new Date(date);

				s.elem.val(date.format(s.opts.format));
				s.opts.year.val(date.getFullYear());
				s.opts.month.val(date.getMonth()+1);
				s.opts.day.val(date.getDate());
			}

			var required = s.elem.prop('required');
			
			s.opts.day.prop('required', required).addClass(s.opts.className);
			s.opts.month.prop('required', required).addClass(s.opts.className);
			s.opts.year.prop('required', required).addClass(s.opts.className);
        	
    		s.elem.after(s.opts.day);
    		s.elem.after(s.opts.month);
    		s.elem.after(s.opts.year);
    		s.elem.prop('type', 'hidden');

        	var selectchange = function(e){
            	try {
            		var date = new Date(s.opts.year.val(), s.opts.month.val() ? parseInt(s.opts.month.val())-1 : '', s.opts.day.val());
            		s.elem.val(date.format(s.opts.format));
            	} catch(err){
                	s.elem.val('');
                }
            }
        	
    		s.opts.year.on('change', selectchange);
    		s.opts.month.on('change', selectchange);
    		s.opts.day.on('change', selectchange);
        }
	}
	
    $.fn[name] = function ( options ) {
        return this.each(function () {
            if (!$.data(this, name)) {
                $.data(this, name, new dropdate( this, options ));
            }
        });
    };
	
})( jQuery, window, document );