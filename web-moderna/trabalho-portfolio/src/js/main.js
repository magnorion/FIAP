(function ($) {
    
    $(document).ready(function(){
        $('nav div ul li a').on('click', function (){
            var self = $(this),
                anchor = self.data('ancora'),
                position = $('#' + anchor).offset();
            
            $('nav div ul li a').removeClass('active');
            self.addClass('active');

            $('html, body').animate({
                scrollTop: (position.top - 100) + 'px'
            });
        });

        $('form button').on('click', function(e) {
            e.preventDefault();
            var nome = $("input[name='nome']").val();
            if (nome != '') {
                alert('Ola '+nome+', obrigado pelo contato!');
            }
        })
    });

})(jQuery);