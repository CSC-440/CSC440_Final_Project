<div class="home-page-template">

    <script type='text/javascript' src='js/x3dom.js'></script>
    <link rel='stylesheet' type='text/css' href='css/x3dom.css' />

    <style>
        #logo_full_screen {
            width: 100vw;
            width: 100%;
            min-height: 100vh;
            max-height: 100%;
            position: absolute;
            top: 0;
            left: 0;
        }
    </style>

    <x3d id="logo_full_screen">
        <scene>
        <Viewpoint position="-0.00275 0.05204 0.09251" orientation="0.00000 0.00000 0.00000 0.00000" description="defaultX3DViewpointNode"></Viewpoint>
        <!-- See note below for info on adjusting the above Viewpoint element values. -->
        <Transform DEF="logos">
            <Inline url="obj/chocanlogo.x3d"></Inline>
        </Transform>
            <timeSensor DEF='clock' cycleInterval='32' loop='true'></timeSensor>
            <!--
            NOTE:     Switch value of loop variable above to stop the spinning.
                      Adjust cycleInterval for rotation rate (lower = higher rate). 
            info:     http://kawahara.ca/x3d-how-to-rotate-an-object/
            -->
            <orientationInterpolator DEF='spinThings' key='0 0.25 0.5 0.75 1' keyValue='0 1 0 0  0 1 0 1.57079  0 1 0 3.14159  0 1 0 4.71239  0 1 0 6.28317'></orientationInterpolator>

            <ROUTE fromNode='clock' fromField='fraction_changed' toNode='spinThings' toField='set_fraction'></ROUTE>
            <ROUTE fromNode='spinThings' fromField='value_changed' toNode='logos' toField='set_rotation'></ROUTE>

            <NavigationInfo type='none'>
            <!--
            NOTE:   If you comment-out the NavigationInfo element above,
                    you can adjust the position of the object.
            
                    Object Movement:
                    
                    cntr + lft-mouse + move mouse   : Moves object up/down and left/right.
                    lft-mouse + move mouse          : Moves object ...
                    rit-mouse + mouse               : Moves object ...
                    
                    Keyboard Shortcuts!
                    (useful when the Navigation is enabled)
            
                    'd' : Opens the "nav" browser console.
                    'v' : Outputs the viewpoint to the browser console.
                    'r' : Returns the object to it's original placement.
            -->
        </scene>
    </x3d>
</div>