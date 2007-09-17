
# This script generates webapp/META-INF/context.xml
# > ruby generateContext.rb (template file) (path to the config file) (docBase) (application path) 

templateFile = ARGV[0] 
configFile = ARGV[1] || "ModernSCMD.config"
docBase = ARGV[2] || "ModernSCMD.war"
applicationPath = ARGV[3] || "/ModernSCMD"


if !(File.file? templateFile)
  puts "#{templateFile} doesn't exist"
  exit
end

replacement =[
  [/\$\{docbase\}/i, docBase],
  [/\$\{application\.path\}/i, applicationPath],
  [/\$\{config\.file\}/i, configFile]
]

open(templateFile, 'r').each { |l|
  replacement.each { |pattern, var|
    l.gsub!(pattern, var)
  }
  puts l
}
