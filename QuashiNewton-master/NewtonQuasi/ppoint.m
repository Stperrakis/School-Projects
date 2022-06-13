function [ f1 ] = sign( x,z,f1 )

if(x(1)<10&&x(1)>-10&&x(2)<10&&x(2)>-10)
hold on
shading interp
plot3(x(1),x(2),z, 'g*');
end

% hold off;
end

