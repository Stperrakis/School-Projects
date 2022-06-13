function [ child1 child2 ] = calcDecimal( x,y )
%CALCDECIMAL Summary of this function goes here
%   Detailed explanation goes here
    a = bi2de(x(:,2:size(x,2)))';
    b = bi2de(y(:,2:size(x,2)))';
    for i = 1:size(x,1)
        if x(i,1)==1
            a(i) = a(i)*(-1);
        end
        if y(i,1)==1
            b(i) = b(i)*(-1);
        end
    end
    child1 = a;
    child2 = b;
end

