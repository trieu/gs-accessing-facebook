<div>            
    <nav class="navbar navbar-default" role="navigation">
        <div class="container">
            <div class="navbar-header">
                <a class="navbar-brand" href="#">OAuth social media demo</a>
            </div>
            <div>
            	[#if currentUserConnection??]
                <p class="navbar-text navbar-right">
                    Signed in using
                    [#if currentUserConnection.providerId == 'facebook']                                                        
                    <a class="ml btn btn-social-icon btn-sm btn-facebook"><i class="fa fa-facebook"></i></a>                            
                    as <a href="${currentUserConnection.profileUrl}" class="navbar-link"><span>${currentUserDisplayName}</span></a>
                    <img src="${currentUserConnection.imageUrl}" width="32" height="32" />
                    [/#if]
                </p>
                [/#if]
            </div>
        </div>
    </nav>
</div>
