FILESEXTRAPATHS_prepend_coral-dev := "${THISDIR}/files:"

SRC_URI += "file://0001-add-BOARD-argument.patch"

BOARD_coral-dev = "phanbell"

# The default make script assuming that the dtb is named fsl-imx8mq-evk.dtb,
# hence we provide an patch to accept a new argument "BOARD" to be able to
# override the "evk" of the assumed dtb name
do_compile_coral-dev() {
    compile_${SOC_FAMILY}
    # mkimage for i.MX8
    for target in ${IMXBOOT_TARGETS}; do
        bbnote "building ${SOC_TARGET} - ${target} - ${BOARD}"
        make SOC=${SOC_TARGET} ${target} BOARD=${BOARD}
        if [ -e "${BOOT_STAGING}/flash.bin" ]; then
            cp ${BOOT_STAGING}/flash.bin ${S}/${BOOT_CONFIG_MACHINE}-${target}
        fi
    done
}
