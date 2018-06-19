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

        $('#principal-content').animate({opacity: 1, marginTop: '5vh'},
            1500);

        $('form button').on('click', function(e) {
            e.preventDefault();
            var nome = $("input[name='nome']").val();
            if (nome != '') {
                alert('Ola '+nome+', obrigado pelo contato!');
            }
        })
    });

})(jQuery);