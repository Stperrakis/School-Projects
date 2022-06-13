clc;
clear;
k = 10;
divisor = 'P input:';
divisor = input(divisor);
bad = 0;
e = 1e-3;
for counter = 1 : 100
MSG = round(rand(1,k));

Register = [MSG,zeros(1,length(divisor)-1)];
fcs = zeros(1,length(divisor)-1);

shift = find(Register == 1);
i = shift(1);
%% message construction
while i <length(MSG)
    shift = 0;
    a = i:i+length(divisor)-1;
    m = max(a);
    r = xor(Register(a),divisor);
    Register(a) = r ;   
    fcs = Register(length(MSG)+1:length(Register));
    if m>length(MSG)
        break;
    end
    shift = find(Register == 1);
    if isempty(shift)
        fcs = zeros(1,length(divisor)-1);
        break;
    end
    i =shift(1);
end
fprintf("The FCS is : \n");
disp(fcs);

fprintf("The message that has to be sent is : \n");
disp([MSG,fcs]);
error_pooling = rand(1,length(Register));
change_bits = find(error_pooling<=e);
Register(change_bits)~=Register(change_bits);

%% message checking
while i <length(MSG)
    shift = 0;
    a = i:i+length(divisor)-1;
    m = max(a);
    r = xor(Register(a),divisor);
    Register(a) = r ;   
    fcs = Register(length(MSG)+1:length(Register));
    if m>length(MSG)
        break;
    end
    shift = find(Register == 1);
    if isempty(shift)
        fcs = zeros(1,length(divisor)-1);
        break;
    end
    i =shift(1);
end
find_error = find(Register==1);
if ~isempty(find_error)
    bad = bad+1;
end
end
Percent_of_Bad = bad/100


