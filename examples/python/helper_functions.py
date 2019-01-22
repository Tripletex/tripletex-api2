import configparser


def read_config(config_file):
    ini_config = configparser.ConfigParser()
    ini_config.read(config_file)
    return ini_config
