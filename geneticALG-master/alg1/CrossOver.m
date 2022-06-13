function [ x,y ] = CrossOver( x,y,nvar,pmutat,cross )
n = 10;         % number bits for integer part of your number      
m = 16;         % number bits for fraction part of your number

for i = 1:nvar
na = abs(x(i));
nb = abs(y(i));

d2b1 = [fix(rem(na*pow2(-(n-1):m),2))]; 
d2b2 = [fix(rem(nb*pow2(-(n-1):m),2))]; 

lel2 = length(d2b2);



if cross == 1;
newC1 = [d2b2(24:(lel2)),d2b1(4:23),d2b2(1:3)];
newC2 = [d2b1(24:(lel2)),d2b2(4:23),d2b1(1:3)];
else
   newC1 = d2b1+d2b2;
   newC1(newC1==2) =0 ;
   newC2 = d2b1+d2b2;
   newC2(newC2==2) = 0 ;
end
%mutation
% pmut = rand(1);
% signmut0 = 0;
% if(pmut>pmutat)
%     j = randi([1,fix(length(newC1))]);
%     newC1(j)=1-newC1(j);
%     signmut0= 1;
% end
% %mutation
% pmut = (100).*rand(1);
% signmut = 0;
% if(pmut>pmutat)
%     j = randi([1,fix(length(newC2)/4)]);
%     newC2(j)=1-newC2(j);
%     signmut = 1;
% end

b2d2 = newC2*pow2([n-1:-1:0 -(1:m)].');
b2d1 = newC1*pow2([n-1:-1:0 -(1:m)].');

% if(signmut0>0)
%     y(i) = -1*sign(x(i))*b2d1;
% else
    y(i) = sign(y(i))*b2d1;
% end
% if(signmut>0)
%     x(i) = -1*sign(y(i))*b2d2;
% else
    x(i) = sign(x(i))*b2d2;
% end

end


end

