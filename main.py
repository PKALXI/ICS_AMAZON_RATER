import subprocess
import os
import sys

project_name = sys.argv[1]

project_name = project_name.strip().replace(' ', '-')

os.mkdir(f'C:/Users/kalsi/Documents/Python-Scripts/{project_name}')

os.putenv('NAME', project_name)
os.system('opencode.bat')
