

	function Grafikas ( id_canvas, reiksmes, x_koord_pav, y_koord_pav ) {

			cnv = document.getElementById ( id_canvas  );
			ctx = cnv.getContext ( '2d' );	
			ctx.strokeStyle = "purple";

			x_width = ( cnv.width - 50 );
			y_height = ( cnv.height - 50 );

			x_koord_prad = 30;
			y_koord_prad = y_height + 20;
			
			console.log ( "x_koord_prad: " + x_koord_prad + " y_koord_prad: " + y_koord_prad );	

			ctx.beginPath();
			ctx.moveTo ( x_koord_prad, 40 );
			ctx.lineTo ( x_koord_prad, y_koord_prad + 5 );
			ctx.stroke();
			ctx.strokeStyle = "black";
			ctx.closePath();

			ctx.beginPath();
			ctx.moveTo ( 25, y_koord_prad );
			ctx.lineTo ( 30 + x_width, y_koord_prad );
			ctx.stroke();
			ctx.strokeStyle = "black";
			ctx.closePath();


			min_y = reiksmes [ 0 ] [ y_koord_pav ];
			max_y = reiksmes [ 0 ] [ y_koord_pav ];

			min_x = reiksmes [ 0 ] [ x_koord_pav ];
			max_x = reiksmes [ 0 ] [ x_koord_pav ];

			for ( i = 1; i < reiksmes.length; i++ ) {

				if ( min_y > reiksmes [ i ] [ y_koord_pav ] ) {

					min_y = reiksmes [ i ] [ y_koord_pav ];
				}
				if ( max_y < reiksmes [ i ] [ y_koord_pav ] ) {

					max_y = reiksmes [ i ] [ y_koord_pav ];
				}
				if ( min_x > reiksmes [ i ] [ x_koord_pav ] ) {

					min_x = reiksmes [ i ] [ x_koord_pav ];
				}
				if ( max_x < reiksmes [ i ] [ x_koord_pav ] ) {

					max_x = reiksmes [ i ] [ x_koord_pav ];
				}
			}

			y_range = max_y - min_y;	
			console.log ( "min_y: " + min_y + " max_y: " + max_y  + " y_range: " + y_range );			
			x_range = max_x - min_x;	

			y_grid_dy = ( y_height - 20 ) / 4;

			y_grid_val_dy = ( max_y - min_y ) / 4;
			y_grid_val = min_y;
			console.log ( "min_y: " + min_y + " max_y: " + max_y  + " y_grid_val_dy: " + y_grid_val_dy );

			x_grid_dx = x_width / 4;
			x_grid_val_dx = ( max_x - min_x ) / 4;
			x_grid_val = min_x;	
																																												// Vertikalios
			for ( i = 0; i < 5; i++ ) {
			 
				ctx.moveTo ( x_koord_prad + x_grid_dx * i, x_koord_prad - 10 );
				ctx.lineTo ( x_koord_prad + x_grid_dx * i, y_koord_prad );
			 
				ctx.fillText( x_grid_val, x_koord_prad + x_grid_dx * i,/* x_koord_prad - 10, x_koord_prad + x_grid_dx * i,*/ y_koord_prad );
				x_grid_val += x_grid_val_dx;
			}
																																									//Horizontalios
			for ( i = 0; i < 5; i++ ) {

				ctx.moveTo ( x_koord_prad, y_koord_prad - y_grid_dy * i );
				ctx.lineTo ( x_koord_prad + x_width, y_koord_prad - y_grid_dy * i );

				ctx.fillText(y_grid_val, x_koord_prad, y_koord_prad - y_grid_dy * i);
				ctx.fillText (  y_grid_val, x_koord_prad, y_koord_prad - y_grid_dy * i );
				y_grid_val += y_grid_val_dy;
				console.log ( "y_grid_val: " + y_grid_val );
			}
			
			ctx.stroke();
			ctx.closePath();				

			ctx.beginPath();
			ctx.moveTo ( x_koord_prad, y_koord_prad );			

			for ( i = 0; i < reiksmes.length; i++ ) {

				x_koord = x_koord_prad + ( ( reiksmes [ i ] [ x_koord_pav ] - min_x ) / x_range ) * x_width;

				y_koord = y_koord_prad - ( ( reiksmes [ i ] [ y_koord_pav ] - min_y ) / y_range ) * ( y_height - 20 );

				console.log ( "x: " + x_koord.toFixed( 2 ) + " y: " + y_koord.toFixed ( 2 )  + " : " + ( reiksmes [ i ] [ y_koord_pav ] ) + " : " +  ( reiksmes [ i ] [ y_koord_pav ] - min_y )   );

				ctx.lineTo ( x_koord,  y_koord );
			}	

			ctx.stroke();
			ctx.closePath();	
		} 