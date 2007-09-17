require 'erb'

# run your erb script from the ruby command
# ruby erb.rb your_erb.erb 

erbFile = ARGV[0]

print ERB.new(open(erbFile).read, nil, ">").result
